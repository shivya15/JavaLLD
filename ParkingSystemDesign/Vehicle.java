package ParkingSystemDesign;

import java.time.LocalDateTime;

public class Vehicle {
    private String registrationNumber;
    private VehicleType type;
    private LocalDateTime entryTime;
    private String parkingSlotId;

    public Vehicle(String registrationNumber, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.entryTime = LocalDateTime.now();
        this.parkingSlotId = null;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
		return this.type;
	}

    public void setVehicleType(VehicleType type) {
		this.type = type;
	}

    public LocalDateTime getEntryTime() {
        return this.entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getParkingSlotId() {
        return this.parkingSlotId;
    }

    public void setParkingSlotId(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    @Override
    public String toString(){
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", type=" + type +
                ", entryTime=" + entryTime +
                ", parkingSpotId='" + parkingSlotId + '\'' +
                '}';
    }



}
