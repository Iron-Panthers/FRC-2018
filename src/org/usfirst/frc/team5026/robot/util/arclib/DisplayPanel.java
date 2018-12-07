package org.usfirst.frc.team5026.robot.util.arclib;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class DisplayPanel extends JPanel implements ActionListener {
	protected JTextField xString;
	protected JTextField yString;
	protected JTextField index;
	public static ArrayList<Color> colors;
	protected JTextArea displayArea;
	private final static String newline = "\n";
	JButton b;
	JButton saver;
	JButton backwards;
	ArrayList<Arc> arcs;
	public static boolean colorChanged = false;
	public static int indexInt = 0;
	public static double tempX = 0;
	public static double tempY = 0;
	public static int arcCounter = 0;
	public boolean backwardsArc = false;
	boolean thisArcDriveReversed;
	
	public DisplayPanel() {

		arcs = new ArrayList<Arc>();
		colors = new ArrayList<Color>();
		
		b = new JButton("create arc");
		b.addActionListener(this);
		backwards = new JButton("toggle backwards/forwards");
		backwards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(backwardsArc == false) {
					backwardsArc = true;
				}
				else {
					backwardsArc = false;
				}
				System.out.println(backwardsArc);
			}
		});
		saver = new JButton("save path");
		saver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("left wheel distances: ");
				for(int i = 0; i < arcs.size(); i++) {
					System.out.println(arcs.get(i).leftWheelDistance + ", ");
				}
				System.out.println("right wheel distances: ");
				for(int i = 0; i < arcs.size(); i++) {
					System.out.println(arcs.get(i).rightWheelDistance + ", ");
				}
			}
		});
//		saver.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				// display/center the jdialog when the button is pressed
//				try{    
//		             FileOutputStream fout=new FileOutputStream("D:\\testout.txt");    
//		             
////		             for(int i; i<arcs.size(); i++) {
//		            	 	
////		            	 	String s = 
////		            	 	byte b[]=s.getBytes();//converting string into byte array    
////		            	 	fout.write(b);  
//		            	 	
////		             }
//		             
//		             fout.close();    
//		             System.out.println("success...");    
//		            }catch(Exception e){System.out.println(e);}
//			}
//		});

		
		xString = new JTextField(80);
		yString = new JTextField(80);
		index = new JTextField(80);

		xString.addActionListener(this);
		yString.addActionListener(this);
		index.addActionListener(this);

		displayArea = new JTextArea(7, 80);
		displayArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(displayArea);

		// Add Components to this panel.
		add(b);
		add(backwards);
		add(saver);
		add(xString);
		add(yString);
		add(index);
		add(scrollPane);

	}

	

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Auto Editor");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DisplayPanel panel = new DisplayPanel();
		// panel.addMouseListener(new MouseAdapter()
		// {
		// public void mouseClicked(MouseEvent me)
		// {
		//// text = "X : " + me.getX() + " Y : " + me.getY();
		// int x = me.getX();
		// int y = me.getY();
		// System.out.println("x:" + x);
		// System.out.println("y:" + y);
		//// panel.setValues(text, x, y);
		//
		// }
		// });

		// Add contents to the window.
		frame.add(panel);
		// Display the window.
		frame.setSize(1240, 720);
		frame.setVisible(true);
		frame.repaint();
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();

			}
		});
	}

	//adds or removes an arc to the array based on user input
	@Override
	public void actionPerformed(ActionEvent evt) {

		try {
			
			
			indexInt = (int) Math.round(Double.parseDouble(index.getText()));
			
			// add a new arc to the array using the point and index that the user typed in
			if(!(xString.getText().matches("REMOVE"))) {
				// store user inputs
				tempX = Double.parseDouble(xString.getText());
				tempY = Double.parseDouble(yString.getText());
				
				//add the arc based on previous arc values or known values if its the first arc
				if (indexInt == 0)
					arcs.add(indexInt, new Arc(0, 0, tempX, tempY, 1000000000, -0.00000001, -0.0001, backwardsArc));
				else
					arcs.add(indexInt,
							new Arc(arcs.get(indexInt - 1).c, arcs.get(indexInt - 1).d, tempX, tempY,
									arcs.get(indexInt - 1).endSlope, arcs.get(indexInt - 1).nextTestX,
									arcs.get(indexInt - 1).nextTestY, backwardsArc));
			}
			
			//remove an arc if "REMOVE" is entered
			else if(xString.getText().matches("REMOVE")) {
				arcs.remove(indexInt);
			}
			
			//recalibrate the array by retaining c, d, and isBackwards from each arc, but resetting a and b 
			//based on values from the previous arc
			thisArcDriveReversed = false;
			for(int i = 0; i < arcs.size(); i++) {
				boolean tempArcIsBackwards;
				if(i==0) {
					double otherTempX = arcs.get(0).c;
					double otherTempY = arcs.get(0).d;
					tempArcIsBackwards = arcs.get(0).isBackwards;
					arcs.remove(0);
					arcs.add(0, new Arc(0, 0, otherTempX, otherTempY, 1000000000, -0.00000001, -0.0001, tempArcIsBackwards));
				}
				
				else {
					double otherTempX = arcs.get(i).c;
					double otherTempY = arcs.get(i).d;
					tempArcIsBackwards = arcs.get(i).isBackwards;
					arcs.remove(i);
					arcs.add(i, 
							new Arc(arcs.get(i - 1).c, arcs.get(i - 1).d, otherTempX, otherTempY,
									arcs.get(i - 1).endSlope, arcs.get(i - 1).nextTestX,
									arcs.get(i - 1).nextTestY, tempArcIsBackwards));
				}
				if(tempArcIsBackwards && thisArcDriveReversed) {
					thisArcDriveReversed = false;
					arcs.get(i).robotIsReversed = thisArcDriveReversed;
				}
			
				else if(tempArcIsBackwards) {
					thisArcDriveReversed = true;
					arcs.get(i).robotIsReversed = thisArcDriveReversed;
					System.out.println("marker 1");
				}
				arcs.get(i).recalibrateDistances();
			}

			//colors.add(indexInt, JColorChooser.showDialog(null, "pick your color", Color.BLACK)); I might do this at some point if it seems valuable

		}

		catch (Exception e) {
			System.out.println("IOException: " + e);
			System.out.println("pick valid bois");

			return;
		}
		
		xString.selectAll();

		// Make sure the new text is visible, even if there
		// was a selection in the text area.
		displayArea.setCaretPosition(displayArea.getDocument().getLength());

		//rewrite display
		displayArea.setText("");
		for (int i = 0; i < arcs.size(); i++) {
			displayArea.append("Arc " + i + "; 1st point: " + arcs.get(i).a + "," + arcs.get(i).b + "; 2nd point: " + arcs.get(i).c + "," + arcs.get(i).d + "; backwards: " + arcs.get(i).isBackwards);
			displayArea.append("\n");
		}

		//redraw the arcs. As far as I can tell this just calls PaintComponent()
		repaint();
	}
	
	//draws the arcs based on the array
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//clear the canvas
		g.clearRect(0, 0, (int)this.getSize().width, (int)this.getSize().height);
		this.setBackground(Color.WHITE);
		
		//redraw arcs
		if(arcs.size() > 0) {
			for (int i = 0; i < arcs.size(); i++) {
				Arc temp = arcs.get(i);
				// taking elements from the arc class and readying them to feed into the drawArc
				// method
				// this is somewhat annoying but i'm too lazy to change the code
				// structure at this point
				int x = (int) Math.round(temp.centerX - temp.radius);
				int y = (int) Math.round(temp.centerY - temp.radius);
				int width = (int) Math.round(2 * temp.radius);
				int height = (int) Math.round(2 * temp.radius);
				int startAngle = -((int) Math.round((180 * temp.startAngle) / Math.PI));
				int angle = (int) Math.round((180 * temp.angle) / Math.PI);

				// holy s*** we did it boys (yeah thats right i starred out s***, ok. Not about
				// to sacrifice my gracious professionalism here.)
				
				

				//Draw an arc. The origin has been translated to 620, 500 on the original grid. Note that the original
				//Jframe measures y coordinates downwards from the top and x coordinates rightwards from the left side
				//for this reason,  the surrounding rectangle has been vertically flipped via using negative angles
				//and moving the corner by -height
				g.drawArc(x + 620, -y + 500 - height, width, height, -startAngle, -angle);
				
				// g.drawRect(x + 620, -y + 500 - height, width, height); uncomment to view surrounding rectangles for arcs

				// arcs.get(i).displayValues(); - do if you wanna see the values cuz they're bad

			}
		}
		
		//draw the x and y axis
		g.drawLine(620, 0, 620, 720);
		g.drawLine(0, 500, 1240, 500);

	}
}