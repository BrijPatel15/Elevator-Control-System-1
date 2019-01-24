//****************************************************************************
//
// Filename: ElevatorSubsystemMain.java
//
// Description: Elevator Subsystem Main Class
//
//***************************************************************************

package core.Subsystems.ElevatorSubsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.ConfigurationParser;
import core.LoggingManager;
import core.Subsystems.ElevatorSubsystem.ElevatorSubsystem;


public class ElevatorSubsystemMain {

	private static Logger logger = LogManager.getLogger(ElevatorSubsystemMain.class);
	
	public static void main(String[] args) {
		
		logger.info(LoggingManager.BANNER + "Elevator Subsystem\n");
		
		try {
			ConfigurationParser configurationParser = ConfigurationParser.getInstance();
			
			int numElev = configurationParser.getInt(ConfigurationParser.NUMBER_OF_ELEVATORS);
			int numFloors = configurationParser.getInt(ConfigurationParser.NUMBER_OF_FLOORS);
			
			ElevatorSubsystem elevatorSystem = new ElevatorSubsystem(numElev, numFloors);
			elevatorSystem.activateElevators();		
		} catch (Exception e) {
			logger.error("", e);
            System.exit(-1);
		}
		
		System.exit(0);
		
	}

}