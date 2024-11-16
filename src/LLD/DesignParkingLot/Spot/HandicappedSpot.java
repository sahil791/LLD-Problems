package LLD.DesignParkingLot.Spot;

import LLD.DesignParkingLot.Enums.ParkingSlotType;

public class HandicappedSpot extends ParkingSpot{
    public HandicappedSpot(String id, String name, ParkingSlotType parkingSlotType) {
        super(id, ParkingSlotType.HANDICAPPED);
    }
}
