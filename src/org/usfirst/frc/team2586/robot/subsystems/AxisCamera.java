package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AxisCamera extends Subsystem {
	
	private static final String ID_FMT = "cam%d";
	
	private final String id;
	private final Servo servoX, servoY, eyeServo;
	
	// TODO what does eyeServo even do??
	
	public AxisCamera() {
		this(0, RobotMap.CAM_X_SERVO, RobotMap.CAM_Y_SERVO, RobotMap.CAM_EYE_SERVO);
	}
		
	public AxisCamera(int id, int servoX, int servoY, int eyeServo) {
		this(id, new Servo(servoX), new Servo(servoY), new Servo(eyeServo));
	}
	
	public AxisCamera(int id, Servo servoX, Servo servoY, Servo eyeServo) {
		super("Axis Camera");
		
		this.id = String.format(ID_FMT, id);
		
		this.servoX = servoX;
		this.servoY = servoY;
		this.eyeServo = eyeServo;
	}
	
	public void setMotors(double x, double y) {
		this.servoX.set(x);
		this.servoY.set(y);
	}
	
	public void startAutoCapture(int quality) {
		CameraServer srv = CameraServer.getInstance();
		
		srv.setQuality(quality);
		srv.startAutomaticCapture(id);
	}
	
	public boolean isAutoCapturing() {
		CameraServer srv = CameraServer.getInstance();
		
		return srv.isAutoCaptureStarted();
	}

	@Override
	protected void initDefaultCommand() {}

}
