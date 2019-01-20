package elevatorsystem;

import elevator.IElevator;

/**
 * <p>
 * this interface is implemented by {@link ElevatorSystem}.
 * it is used by {@link IElevator} to call back to {@link ElevatorSystem}
 * regarding the the floor to which {@link IElevator} intends to travel.
 * </p>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Jan 30, 2018
 */
public interface IElevatorPanel{

	/**
	 * called from {@link IElevator} to inform {@link ElevatorSystem} of new floor.
	 * @param floor - new floor to which {@link IElevator} is moving.
	 * @param elevator - reference to the calling elevator.
	 */
	void requestStop( final int floor, IElevator elevator);
}
