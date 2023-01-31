package model;

public abstract class Vehicle {
    private String vehicleNum;

    private VehicleCategory vehicleCategory;

    public Vehicle(String vehicleNum, VehicleCategory vehicleCategory) {
        this.vehicleNum = vehicleNum;
        this.vehicleCategory = vehicleCategory;
    }

    public VehicleCategory getVehicleCategory(){
        return vehicleCategory;
    }

    public void setVehicleCategory( VehicleCategory vehicleCategory ){
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleNum(){
        return vehicleNum;
    }

    public void setVehicleNum( String vehicleNum ){
        this.vehicleNum = vehicleNum;
    }

    @Override
    public String toString(){
        return "model.Vehicle{" +
                ", vehicleNum=" + vehicleNum +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }
}
