package elevatorsystem;

import elevator.IElevator;

/**
 * <p>
 * {@link IElevatorController} guideline to be used.
 * these methods represent possible methods for {@link IElevatorController}
 * </p>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Jan 30, 2018
 */
public interface IElevatorController{

	/**
	 * get total floors to which {@link IElevatorController} can send an {@link IElevator}.
	 * behavior and definition of this method will likely change when more elevators are introduced.
	 * @return total floors
	 */
	int getFloorCount();
	
	/**
	 * get maximum floor for this {@link IElevatorController}
	 * @return maximum floor for this {@link IElevatorController}
	 */
	int getMaxFloor();
	
	/**
	 * get minimum floor for this {@link IElevatorController}
	 * @return minimum floor for this {@link IElevatorController}
	 */
	int getMinFloor();
	
	/**
	 * when calling up it means the passenger intends to travel to a higher floor.
	 * @param floor - passengers current floor when calling for an {@link IElevator}
	 * @return an {@link IElevatorController} that has reach the requested floor
	 */
	IElevator callUp( final int floor);
	
	/**
	 * when calling down it means the passenger intends to travel to a lower floor.
	 * @param floor - passengers current floor when calling for an {@link IElevator}
	 * @return an {@link IElevatorController} that has reach the requested floor
	 */
	IElevator callDown( final int floor);

	/**
	 * return current floor of {@link IElevator} in {@link IElevatorController}.
	 * since there is only 1 {@link IElevator} no need for any arguments.
	 * this method will likely change inn future designs.
	 * @return current floor of only {@link IElevator}
	 */
	int getCurrentFloor();
	
	/**
	 * return total power consumed by all {@link IElevator} in the {@link IElevatorController}
	 * @return total power consumed
	 */
	double getPowerConsumed();
	
	/**
	 * add an {@link IElevator} to {@link IElevatorController}, if implemented multiple {@link IElevator} can be added
	 * @param elevator - {@link IElevator} object to be added to {@link IElevatorController}
	 */
	void addElevator( IElevator elevator);
}