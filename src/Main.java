import api.ParkingLotManager;
import exception.ParkingFullException;
import exception.VehicleTypeException;
import model.Ticket;
import model.TwoWheelerVehicle;
import model.Vehicle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ParkingFullException, VehicleTypeException {
        try {
            String configFilePath = "src/config.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(propsInput);
            int numTwoWheelerSlots = Integer.parseInt( prop.getProperty("numTwoWheelerSlots") );
            int numFourWheelerSlots = Integer.parseInt( prop.getProperty("numFourWheelerSlots") );
            ParkingLotManager parkingLot = ParkingLotManager.getInstance( numTwoWheelerSlots, numFourWheelerSlots);
            Vehicle vehicle = new TwoWheelerVehicle("Mh12" );

            Ticket ticket = parkingLot.parkVehicle(vehicle);
            System.out.println(ticket);

            Vehicle vehicle2 = new TwoWheelerVehicle("Mh13");

            Ticket ticket2 = parkingLot.parkVehicle(vehicle2);
            System.out.println(ticket2);
            System.out.println("Hello world!");
        }
        catch( FileNotFoundException e ){
            e.printStackTrace();
        }
        catch(  IOException e ){
            e.printStackTrace();
        }
    }
}