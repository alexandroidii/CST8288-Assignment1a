/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.Observable;
import elevatorsystem.IElevatorPanel;

/**
 *
 * @author alexr
 */
public class ElevatorModel extends Observable implements IElevator {

    private static final int POWER_START_STOP = 2;
    private static final int POWER_CONTINUOUS = 1;
    private static final long SLEEP_START_STOP = 50;
    private static final long SLEEP_CONTINUOUS = 25;
    private final double MAX_CAPACITY_PERSONS;
    
    private double powerUsed;
    private int currentFloor;
    private int capacity;
    private IElevatorPanel panel;
    private MovingState state;
    
    
    public ElevatorModel(double CAPACITY_PERSONS, IElevatorPanel panel){
        this.MAX_CAPACITY_PERSONS = CAPACITY_PERSONS;
        this.powerUsed = 0.0;
        this.currentFloor = 0;
        this.capacity = 0;
        this.panel = panel;
        this.state = MovingState.Idle;
    }
    
    @Override
    public void moveTo(int targetFloor) {
        
        /*
        Change the state at the following:
        the first thing you do is move slow always.  Maybe a Do/While would be good for that.
        Then when you are in the while loop, loops though at normal speed until you are 1 floor away from the destination
        When you are done the loop, the only thin left is to slowly stop.
        
        1. state = idle
        2. state = slow (start moving)
        3. state = normal (loop through moving normally until you are 1 floor away from destination
        4. state = slow for the last step.
        
        every start consums 2.
        while(
        */
        
        if(targetFloor < 0){
            System.out.println(targetFloor + " does not exists.");
            return;
        }
        
        if(getFloor() == targetFloor){
            System.out.println("You have arrived at floor " + targetFloor );
            return;
        }
        
        
        
        while(getFloor() != targetFloor){ //not already on that floor
            System.out.print("The Elevator changed from state " + getState());
            double tempPower;
            
            if(getState() == MovingState.Idle || Math.abs(targetFloor - getFloor()) <= 1.0){ //verify this is the best abs
                setState(getFloor() < targetFloor ? MovingState.SlowUp : MovingState.SlowDown );
                setPowerConsumed(2.0);
                tempPower = 2.0;
            } else {
                setState(getState().normal());
                setPowerConsumed(1.0);
                tempPower = 1.0;

            }     
            
            System.out.println(" to state " + getState() + " and used " + tempPower + " units of power.");

            setFloor(getFloor() < targetFloor ? getFloor() + 1 : getFloor() - 1);

            System.out.println("Moved to floor " + getFloor());

        }
        
        System.out.print("The Elevator changed from state " + getState());

        setState(MovingState.Idle);
        
        System.out.println(" to state " + getState());

    }
    
    private void processMovingState(int floor){
        // process the power consumption here
    }
    
    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isFull() {
        return getCapacity() > MAX_CAPACITY_PERSONS;
    }

    @Override
    public boolean isEmpty() {
        return getCapacity() == 0;
    }

    @Override
    public MovingState getState() {
        return state;
    }

    public void setState(MovingState state){
        this.state = state;
    }
    
    @Override
    public double getPowerConsumed() {
        return powerUsed;
    }
    
    public void setPowerConsumed(double power){
        this.powerUsed += power;
    }

   

    @Override
    public int getFloor() {
        return currentFloor;
    }

    private void setFloor(int floor){
        this.currentFloor = floor;
    }
    
    @Override
    public void addPersons(int persons) {
        this.capacity += persons;
        System.out.println("picked up " + persons + " passenger(s) at floor " + getFloor() );

    }

    @Override
    public void requestStop(int floor) {
        System.out.println("The elevator is leaving floor " + getFloor() + " to go to floor " + floor );
        moveTo(floor);
    }
    
   
    
}
