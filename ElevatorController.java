/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsystem;

import elevator.ElevatorModel;
import elevator.MovingState;
import java.util.Observable;
import java.util.Observer;
import elevator.IElevator;

/**
 *
 * @author alexr
 */
public class ElevatorController implements IElevatorController, IElevatorPanel, Observer {

    private final int MAX_FLOOR;
    private final int MIN_FLOOR;
    private IElevator elevator;
    
    public ElevatorController(int MIN_FLOOR, int MAX_FLOOR){
       this.MAX_FLOOR = MAX_FLOOR;
       this.MIN_FLOOR = MIN_FLOOR;
    }
    
    private void floorCheck(int floor){
        
    }
    
    private IElevator call(int floor, MovingState direction){
        return null; //todo return the proper value
    }
    
    private boolean checkForElevator(){
        return elevator != null ? true : false; //todo return the proper value
    }
    
    @Override
    public int getFloorCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxFloor() {
        return MAX_FLOOR;
    }

    @Override
    public int getMinFloor() {
        return MIN_FLOOR;
    }

    @Override
    public IElevator callUp(int floor) {
        System.out.println("Elevator has been called to floor " + floor + " to carry a passenger up.");
        elevator.moveTo(floor);
        return elevator;
    }

    @Override
    public IElevator callDown(int floor) {
        System.out.println("Elevator has been called to floor " + floor + " to carry a passenger down.");
        elevator.moveTo(floor);
        return elevator;
    }

    @Override
    public int getCurrentFloor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPowerConsumed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addElevator(IElevator elevator) {
        this.elevator = elevator;
        ((ElevatorModel)elevator).addObserver(this);
    }

    @Override
    public void requestStop(int floor, IElevator elevator) {
        System.out.println("The elevator is leaving floor " + getCurrentFloor() + " to go to floor " + floor );
        elevator.moveTo(floor);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
