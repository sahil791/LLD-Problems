package Prototype;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static class ParkingLot {
        private Semaphore spaces;

        public ParkingLot(int capacity) {
            spaces = new Semaphore(capacity);
        }

        public void parkCar(String car) {
            try {
                spaces.acquire();  // Try to get a parking space
                System.out.println(car + " parked");
                Thread.sleep(2000);  // Car stays parked for 2 seconds
                System.out.println(car + " leaving");
                spaces.release();  // Release the parking space
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);  // Parking lot with 3 spaces

        // Create 5 cars trying to park simultaneously
        for (int i = 1; i <= 5; i++) {
            final String car = "Car " + i;
            new Thread(() -> parkingLot.parkCar(car)).start();
        }
    }
}
