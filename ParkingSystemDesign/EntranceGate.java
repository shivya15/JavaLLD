package ParkingSystemDesign;

public class EntranceGate {
    private String gateId;
    private ParkingLot parkingLot;

    public EntranceGate(String gateId) {
        this.gateId = gateId;
    }
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public ParkingTicket processVehicleEntry(Vehicle vehicle) {
        ParkingSpot availableSpot = parkingLot.findAvailableSpot(vehicle.getVehicleType());

        if (availableSpot != null) {
            if (availableSpot.parkVehicle(vehicle)) {
                vehicle.setParkingSlotId(availableSpot.getSpotId());
                return generateTicket(vehicle, availableSpot);
            } else {
                System.out.println("Error parking vehicle in spot " + availableSpot.getSpotId());
                return null;
            }
        } else {
            System.out.println("No available parking spot for " + vehicle.getVehicleType());
            return null;
        }
    }

    private ParkingTicket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        return new ParkingTicket(vehicle, spot);
    }

}
