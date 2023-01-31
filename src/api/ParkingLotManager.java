package api;

import exception.ParkingFullException;
import exception.VehicleTypeException;
import model.*;
import service.ParkingLotService;

public class ParkingLotManager implements Parking {
    private static ParkingLotManager INSTANCE = null;
    private ParkingLotService parkingLotService;
    private ParkingLotManager( int numTwoWheelerSlots, int numFourWheelerSlots ){
        this.parkingLotService = ParkingLotService.getInstance( numTwoWheelerSlots, numFourWheelerSlots );
    }
    public static ParkingLotManager getInstance( int numTwoWheelerSlots, int numFourWheelerSlots ) {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLotManager( numTwoWheelerSlots, numFourWheelerSlots );
        }
        return INSTANCE;
    }
    public Ticket parkVehicle(Vehicle vehicle) throws VehicleTypeException, ParkingFullException {
        if( vehicle.getVehicleCategory() != VehicleCategory.TWO_WHEELER && vehicle.getVehicleCategory() != VehicleCategory.FOUR_WHEELER ){
            throw new VehicleTypeException("Vehicle Type not supported");
        }
        return parkingLotService.parkVehicle( vehicle );
    }
}
