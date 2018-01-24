    motor2.set(ControlMode.PercentOutput, speed);
    motor3.set(ControlMode.PercentOutput, speed);
  }
  public void driveWithTarget(double target) {
    motor1.set(ControlMode.MotionMagic, target);
    motor2.set(ControlMode.MotionMagic, target);    
    motor3.set(ControlMode.MotionMagic, target);  
  }
  public void stop() {
    motor1.set(ControlMode.PercentOutput, 0);
    motor2.set(ControlMode.PercentOutput, 0);
    motor3.set(ControlMode.PercentOutput, 0);
  }
  public void setInverted(boolean isInverted) {
    motor1.setInverted(isInverted);
    motor2.setInverted(isInverted);
    motor3.setInverted(isInverted);
  }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}