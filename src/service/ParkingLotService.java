package service;

import exception.ParkingFullException;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import model.VehicleCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLotService {
    private static ParkingLotService INSTANCE = null;
    private List<ParkingSpot> twoWheelerSlots;
    private List<ParkingSpot> fourWheelerSlots;
    private ParkingLotService( int numTwoWheelerSlots, int numFourWheelerSlots ){
        this.twoWheelerSlots = new ArrayList<>();
        this.fourWheelerSlots = new ArrayList<>();
        for(int i=1;i<=numTwoWheelerSlots;i++){
            this.twoWheelerSlots.add(new ParkingSpot(i));
        }
        for(int i=1;i<=numFourWheelerSlots;i++){
            this.fourWheelerSlots.add(new ParkingSpot(i));
        }
    }

    public static ParkingLotService getInstance( int numTwoWheelerSlots, int numFourWheelerSlots ){
        if(INSTANCE == null){
            INSTANCE = new ParkingLotService( numTwoWheelerSlots, numFourWheelerSlots );
        }
        return INSTANCE;
    }

    public ParkingSpot getNextAvailableSlot(VehicleCategory vehicleCategory) throws ParkingFullException {
        List<ParkingSpot> Slots;
        if( vehicleCategory == VehicleCategory.TWO_WHEELER )
            Slots = twoWheelerSlots;
        else
            Slots = fourWheelerSlots;
        for( ParkingSpot i : Slots ){
            if(i.getIsEmpty()){
                return i;
            }
        }
        throw new ParkingFullException("model.Parking Full");
    }
    public Ticket parkVehicle(Vehicle vehicle) throws ParkingFullException {
        ParkingSpot spot;
        // throw exception if vehicle category not supported
        if( vehicle.getVehicleCategory() == VehicleCategory.TWO_WHEELER ){
            spot = getNextAvailableSlot( VehicleCategory.TWO_WHEELER );
            spot.occupyParking(vehicle);
        }
        else{
            spot = getNextAvailableSlot( VehicleCategory.FOUR_WHEELER );
            spot.occupyParking(vehicle);
        }
        return new Ticket( spot, vehicle, new Date().getTime() );
    }
}
