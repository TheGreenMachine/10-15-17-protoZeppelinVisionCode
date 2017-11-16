package com.edinarobotics.zeppelin.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.edinarobotics.utils.subsystems.Subsystem1816;

import edu.wpi.first.wpilibj.command.Command;

public class Climber extends Subsystem1816{//#maximumkaraoke

	private CANTalon climberTalonOne;
	private CANTalon climberTalonTwo;
	private double climberSpeed;
	
	public Climber(int climberTalonOne, int climberTalonTwo){
		this.climberTalonOne = new CANTalon(climberTalonOne);
		this.climberTalonTwo = new CANTalon(climberTalonTwo);
		this.climberTalonTwo.changeControlMode(TalonControlMode.Follower);
		this.climberTalonTwo.set(climberTalonOne);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		climberTalonOne.set(climberSpeed);
	}
	
	public void setClimberMotor(double speed){
		climberSpeed = speed;
		update();
	}
	
	@Override
	public void setDefaultCommand(Command command) {
		if (getDefaultCommand() != null) {
			super.getDefaultCommand().cancel();
		}
		super.setDefaultCommand(command);
	}

	public CANTalon getClimberTalon(){//pok pok karaoke pok
		return climberTalonOne;
	}
	
	
}
