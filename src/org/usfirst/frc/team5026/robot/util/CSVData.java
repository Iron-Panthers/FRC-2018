package org.usfirst.frc.team5026.robot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVData {
	public static ArrayList<ArrayList<Double>> readFromCsv(String path, int length) {
		File file = new File(path);
		BufferedReader reader = null;
		ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < length; i++) {
			out.add(new ArrayList<Double>());
		}

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    
//		    String header = reader.readLine(); // This is for the header of the CSV. If there is no header, do NOT do this line
		    while ((text = reader.readLine()) != null) {
		        String[] seperated = text.split(",");
		        try {
		        	for (int i = 0; i < out.size(); i++) {
		        		out.get(i).add(Double.parseDouble(seperated[i]));
		        	}
		        } catch (NumberFormatException e) {
		        	// The value was NOT a double/int
		        	// That means it is in the header (probably)
		        	// At this point, could make sure that the arrays are ordered in the way that they are assumed to be, but for now just continue
		        } catch (IndexOutOfBoundsException e) {
		        	// The CSV file was formatted incorrectly. That is really bad, so literally kill the entire command.
		        	System.out.println("THE CSV FILE AT PATH: "+path+" CONTAINS INVALID DATA (IndexOutOfBounds)!\nKILLING ALL COMMNADS!");
		        	return null;
		        }
		    }		    
		} catch (FileNotFoundException e) {
			System.out.println("THE CSV FILE AT PATH: "+path+" COULD NOT BE FOUND!\nKILLING ALL COMMANDS!");
			return null;
		} catch (IOException e) {
			// Command should be killed any time an error is thrown out here
		    e.printStackTrace();
		    return null;
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {}
		}
		return out;
	}
	
	public static ArrayList<ArrayList<Double>> interp(ArrayList<ArrayList<Double>> data) {
		int entries = data.get(0).size();
		ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < data.size(); i++) {
			output.add(new ArrayList<Double>());
		}
		
		for (int i = 1; i < entries; i++) {
			double lastTime = data.get(0).get(i-1);
			double thisTime = data.get(0).get(i);
			int dTime = (int)((thisTime - lastTime) * 1000);
			
			for (double j = 0; j < dTime; j++) {
				double t = j / dTime;
				output.get(0).add(t/1000 + lastTime);
				for (int n = 1; n < data.size(); n++) {
					double lastData = data.get(n).get(i-1);
					double deltaData = data.get(n).get(i) - lastData;
					
					output.get(n).add(deltaData * t + lastData);
				}
			}
		}
		
		for (int n = 0; n < data.size(); n++) {
			output.get(n).add(data.get(n).get(data.get(n).size() - 1));
		}
		
		return output;
	}
	
	
}
