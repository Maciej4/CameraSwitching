package org.usfirst.frc.team972.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	Joystick joy = new Joystick(0);
	private MjpegServer mjpegServer = new MjpegServer("serve_USB Camera 0", 1181);
	private UsbCamera cam0 = new UsbCamera("cam0", 0);
	private UsbCamera cam1 = new UsbCamera("cam1", 1);
	CameraServer videoSink = CameraServer.getInstance();
	
	public void robotInit() {

	}
	
	public void teleopInit() {
		cam0.setFPS(30);
		cam1.setFPS(30);
		videoSink.addServer(mjpegServer);
		videoSink.addCamera(cam0);
		videoSink.startAutomaticCapture("Camera Sink", 2);
	}
	
	public void teleopPeriodic() {
		if(joy.getRawButton(1)) {
			mjpegServer.setSource(cam1);
		} else {
			mjpegServer.setSource(cam0);
		}
		
		
	}
}
