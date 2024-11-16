package LLD.DesignParkingLot;

import LLD.DesignParkingLot.Enums.ParkingTicketStatus;
import LLD.DesignParkingLot.Enums.VehicleType;

public class Vehicle {
    private String number;
    VehicleType vehicleType;

    ParkingTicket ticket;

    public Vehicle(String number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void assignTicket() {
        this.ticket = new ParkingTicket();
    }
}
