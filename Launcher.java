package launcher;

import elevator.ElevatorModel;
import elevator.ElevatorModel;
import elevatorsystem.ElevatorController;
import elevatorsystem.IElevatorController;
import elevatorsystem.IElevatorPanel;
import elevator.IElevator;
import elevator.IElevator;

public class Launcher{

	public static void main( String[] args){
		final int MIN_FLOOR = 0;
		final int MAX_FLOOR = 20;
		IElevatorController system = new ElevatorController( MIN_FLOOR, MAX_FLOOR);
		system.addElevator(new ElevatorModel( 5, (IElevatorPanel)system));
		IElevator elevator = system.callDown( 5);
		elevator.addPersons( 1);
		elevator.requestStop( 0);
                System.out.println("Total power consumed is " + elevator.getPowerConsumed());
	}
}