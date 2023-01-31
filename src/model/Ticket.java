package model;

import model.ParkingSpot;

public class Ticket {
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private long entryTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle, long entryTime ) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public String toString() {
        return "model.Ticket{" +
                ", vehicle=" + vehicle +
                ", entryTime=" + entryTime +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}