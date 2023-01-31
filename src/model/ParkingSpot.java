package model;

public class ParkingSpot {
    private int spotNum;
    private Vehicle vehicle;
    private boolean isEmpty;
    public ParkingSpot(int spotNum ){
        this.spotNum = spotNum;
        this.isEmpty = true;
    }
    public int getSpotNum(){
        return spotNum;
    }
    public void setSpotNum( int spotNum ){
        this.spotNum = spotNum;
    }
    public boolean getIsEmpty(){
        return isEmpty;
    }
    public void setIsEmpty( boolean isEmpty ){
        this.isEmpty = isEmpty;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public void setVehicle( Vehicle vehicle ){
        this.vehicle = vehicle;
    }
    public void freeParking(int spotNum){
        this.isEmpty = true;
        this.vehicle = null;
    }
    public void occupyParking(Vehicle vehicle) {
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    @Override
    public String toString(){
        return "model.ParkingSpot{" +
                ", spotNum=" + spotNum +
                ", vehicle=" + vehicle +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
