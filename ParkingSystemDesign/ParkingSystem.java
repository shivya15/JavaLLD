package ParkingSystemDesign;

public class ParkingSystem {
    public static void main(String[] args) {
        ParkingLot myLot = new ParkingLot("My Parking Lot");
        EntranceGate gate1 = new EntranceGate("EG-01");
        ExitGate gateA = new ExitGate("XG-01");

        myLot.addEntranceGate(gate1);
        myLot.addExitGate(gateA);

        // Simulate vehicle entries
        Vehicle car1 = new Vehicle("KA-01-AB-1234", VehicleType.FOUR_WHEELER);
        ParkingTicket ticket1 = gate1.processVehicleEntry(car1);
        if (ticket1 != null) ticket1.printTicket();

        Vehicle bike1 = new Vehicle("KA-02-CD-5678", VehicleType.TWO_WHEELER);
        ParkingTicket ticket2 = gate1.processVehicleEntry(bike1);
        if (ticket2 != null) ticket2.printTicket();
    }
}
