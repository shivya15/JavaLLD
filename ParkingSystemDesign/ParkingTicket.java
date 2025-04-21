package ParkingSystemDesign;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private String ticketId;
    private String vehicleNumber;
    private String parkingSpotId;
    private LocalDateTime entryTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicleNumber = vehicle.getRegistrationNumber();
        this.parkingSpotId = spot.getSpotId();
        this.entryTime = vehicle.getEntryTime();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void printTicket() {
        System.out.println("\n--- Parking Ticket ---");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Parking Spot: " + parkingSpotId);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("----------------------");
    }
}

