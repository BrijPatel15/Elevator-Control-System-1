//****************************************************************************
//
// Filename: FloorSubsystemMain.java
//
// Description: Floor Subsystem Main Class
//
//***************************************************************************

package core.Subsystems.FloorSubsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.ConfigurationParser;
import core.LoggingManager;
import ui.view.FloorSystemView;

import java.net.InetAddress;

public class FloorSubsystemMain {

	private static Logger logger = LogManager.getLogger(FloorSubsystemMain.class);

	public static void main(String[] args) throws Exception {

		logger.info(LoggingManager.BANNER + "Floor Subsystem\n");
		Thread.sleep(500);
		try {
			ConfigurationParser configurationParser = ConfigurationParser.getInstance();
			
			int numFloors = configurationParser.getInt(ConfigurationParser.NUMBER_OF_FLOORS);
			

			InetAddress schedulerSubsystemAddress = InetAddress.getByName(configurationParser.getString(ConfigurationParser.SCHEDULER_ADDRESS));
			int floorInitPort = configurationParser.getInt(ConfigurationParser.FLOOR_INIT_PORT);
			int numElev = configurationParser.getInt(ConfigurationParser.NUMBER_OF_ELEVATORS);
			FloorSubsystem floorSystem = new FloorSubsystem(numFloors, schedulerSubsystemAddress, floorInitPort, numElev);
			FloorSystemView view = new FloorSystemView(numElev, floorSystem);
			Thread t1 = new Thread(view);
			floorSystem.startFloorThreads();
			t1.start();
		} catch (Exception e) {
			logger.error("", e);
			System.exit(-1);
		}

	}
}
