package model;

import exception.ParkingFullException;
import exception.VehicleTypeException;

public interface Parking {
    public Ticket parkVehicle(Vehicle vehicle) throws VehicleTypeException, ParkingFullException;
}
