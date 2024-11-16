package LLD.DesignParkingLot;

import LLD.DesignParkingLot.Enums.ParkingTicketStatus;

import java.time.LocalDateTime;
import java.util.Random;

public class ParkingTicket {
    private long ticketNumber;
    private long issuedAt;
    private long payedAt;
    private double payedAmount;
    private ParkingTicketStatus parkingTicketStatus;

    public ParkingTicket() {
        Random rand = new Random();
        this.ticketNumber = rand.nextLong();
        this.issuedAt = System.currentTimeMillis();
    }

    public ParkingTicket getTicket() {
        return new ParkingTicket();
    }
}
