package ParkingSystemDesign;

import java.time.LocalDateTime;

public class ExitGate {
    private String gateId;
    private ParkingLot parkingLot;

    public ExitGate(String gateId) {
        this.gateId = gateId;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public double calculateCost(Vehicle vehicle) {
        if (vehicle != null && vehicle.getParkingSlotId() != null) {
            ParkingSpot spot = parkingLot.getParkingSpotById(vehicle.getParkingSlotId());
            if (spot != null) {
                long durationHours = java.time.Duration.between(vehicle.getEntryTime(), LocalDateTime.now()).toHours();
                return durationHours * spot.getPricePerHour();
            }
        }
        return 0.0;
    }

    public void processPayment(Vehicle vehicle, double amount) {
        System.out.println("Payment of $" + amount + " processed for vehicle " + vehicle.getRegistrationNumber());
    }

    public void processVehicleExit(Vehicle vehicle) {
        if (vehicle != null && vehicle.getParkingSlotId() != null) {
            ParkingSpot spot = parkingLot.getParkingSpotById(vehicle.getParkingSlotId());
            if (spot != null) {
                Vehicle unparkedVehicle = spot.unparkVehicle();
                if (unparkedVehicle != null) {
                    System.out.println("Vehicle " + unparkedVehicle.getRegistrationNumber() + " exited from spot " + spot.getSpotId());
                } else {
                    System.out.println("Error unparking vehicle from spot " + spot.getSpotId());
                }
            } else {
                System.out.println("Parking spot with ID " + vehicle.getParkingSlotId() + " not found.");
            }
        }
    }
}
