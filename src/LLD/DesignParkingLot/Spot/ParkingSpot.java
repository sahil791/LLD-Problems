package LLD.DesignParkingLot.Spot;

import LLD.DesignParkingLot.ParkingSlotType;
import LLD.DesignParkingLot.Vehicle;
import LLD.DesignParkingLot.VehicleType;

public abstract class ParkingSpot {
    private String id;
    private ParkingSlotType parkingSlotType;
    private Vehicle vehicle;
    private Boolean isVacant;

    public ParkingSpot(String id, ParkingSlotType parkingSlotType) {
        this.id = id;
        this.parkingSlotType = parkingSlotType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        this.isVacant = true;
        return true;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isVacant = false;
    }

    public Boolean getVacant() {
        return isVacant;
    }

}
