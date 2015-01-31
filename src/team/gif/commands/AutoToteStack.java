package team.gif.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author PatrickUbelhor
 */
public class AutoToteStack extends CommandGroup {
    
    public  AutoToteStack() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	/** Process:
    	 * 1. Drive forward and collect
    	 * 2. Knock over RC
    	 * 3. Drive forward and collect
    	 * 4. Knock over RC
    	 * 5. Drive forward and collect
    	 * 6. Turn
    	 * 7. Drive forward into auto zone
    	 * 8. Place stack
    	 * 9. Reverse
    	 */
    }
}
