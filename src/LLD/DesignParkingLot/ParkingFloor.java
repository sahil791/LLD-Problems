package LLD.DesignParkingLot;

import LLD.DesignParkingLot.Spot.*;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private String name;
    private Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(String name) {
        this.name = name;
        this.parkingSpots = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getId(), spot);
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
    }
}
