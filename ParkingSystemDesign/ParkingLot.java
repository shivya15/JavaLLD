package ParkingSystemDesign;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingSpot> twoWheelerSpots;
    private List<ParkingSpot> fourWheelerSpots;
    private List<EntranceGate> entranceGates;
    private List<ExitGate> exitGates;

     public ParkingLot(String name) {
        this.name = name;
        this.twoWheelerSpots = new ArrayList<>();
        this.fourWheelerSpots = new ArrayList<>();
        this.entranceGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        initializeSpots(4, 6); // Initialize with the given number of spots
    }

    private void initializeSpots(int numTwoWheeler, int numFourWheeler) {
        for (int i = 1; i <= numTwoWheeler; i++) {
            twoWheelerSpots.add(new ParkingSpot("2W-" + String.format("%03d", i), VehicleType.TWO_WHEELER, 10.0)); // Example price
        }
        for (int i = 1; i <= numFourWheeler; i++) {
            fourWheelerSpots.add(new ParkingSpot("4W-" + String.format("%03d", i), VehicleType.FOUR_WHEELER, 20.0)); // Example price
        }
    }

    public void addEntranceGate(EntranceGate gate) {
        this.entranceGates.add(gate);
        gate.setParkingLot(this);
    }

    public void addExitGate(ExitGate gate) {
        this.exitGates.add(gate);
        gate.setParkingLot(this);
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        if (type == VehicleType.TWO_WHEELER) {
            return twoWheelerSpots.stream()
                    .filter(spot -> !spot.isOccupied())
                    .findFirst()
                    .orElse(null);
        } else if (type == VehicleType.FOUR_WHEELER) {
            return fourWheelerSpots.stream()
                    .filter(spot -> !spot.isOccupied())
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public ParkingSpot getParkingSpotById(String spotId) {
        ParkingSpot spot = twoWheelerSpots.stream().filter(s -> s.getSpotId().equals(spotId)).findFirst().orElse(null);
        if (spot != null) return spot;
        return fourWheelerSpots.stream().filter(s -> s.getSpotId().equals(spotId)).findFirst().orElse(null);
    }



    

}
