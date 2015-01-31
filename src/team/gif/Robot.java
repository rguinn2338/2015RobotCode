
package team.gif;

import team.gif.commands.InitElevator;
import team.gif.commands.*;
import team.gif.subsystems.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain chassis = new Drivetrain();
	public static OI oi;
	
	public static final Elevator elevator = new Elevator();

	Command driveInit;
	Command elevInit;
	Command driveInitAuto;
	Command driveInitTeleop;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		elevInit = new InitElevator();
		elevInit.start();
		
		driveInitAuto = new InitDrivetrainAuto();
		driveInitTeleop = new InitDrivetrainTeleop();
		
		driveInitAuto.start();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null) autonomousCommand.cancel();
    	driveInitTeleop.start();
    }


    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }
    
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
