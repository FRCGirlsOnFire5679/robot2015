package org.usfirst.frc.team5679.robot.commands;
/**
 * 
 * Handles raising the claw.
 *
 */
public class RaiseClaw extends CommandBase {
	double speed;
	
	// Constructor.
	public RaiseClaw(double speed) {
		if (speed <= 0) {
			throw new IllegalArgumentException("Speed must be positive to move up.");
		}
		requires(claw);
		this.speed = speed;
	}
	
	// Initializes the class.
	@Override
	protected void initialize() {

	}

	// Executes the movement.
	@Override
	public void execute() {
		claw.clawUp(speed);
	}
	
	// Returns whether the movement is finished.
	@Override
	public boolean isFinished() {
		return claw.isUpperLimit();
	}

	// Ends the movement.
	@Override
	public void end() {
		claw.clawStop();
	}

	// Interrupts the movement.
	@Override
	public void interrupted() {
		end();
	}
}
