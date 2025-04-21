package ParkingSystemDesign;

public class ParkingSpot {
    private String spotId;
    private boolean isOccupied;
    private Vehicle vehicleInfo;
    private double pricePerHour;
    private VehicleType type;

    public ParkingSpot(String spotId, VehicleType type, double pricePerHour) {
        this.spotId = spotId;
        this.isOccupied = false;
        this.vehicleInfo = null;
        this.pricePerHour = pricePerHour;
        this.type = type;
    }

    public String getSpotId() {
        return this.spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public Vehicle getVehicleInfo() {
        return this.vehicleInfo;
    }

    public void setVehicleInfo(Vehicle vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public double getPricePerHour() {
        return this.pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public VehicleType getType() {
        return this.type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(!isOccupied && vehicle.getVehicleType()==this.type){
            this.isOccupied = true;
            this.vehicleInfo = vehicle;
            return true;
        }
        return false;
    }

    public Vehicle unparkVehicle(){
        if(!isOccupied){
            Vehicle parkedVehicle=this.vehicleInfo;
            this.isOccupied = false;
            this.vehicleInfo = null;
            return parkedVehicle;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                ", isOccupied=" + isOccupied +
                ", pricePerHour=" + pricePerHour +
                ", type=" + type +
                ", vehicleInfo=" + (vehicleInfo != null ? vehicleInfo.getRegistrationNumber() : null) +
                '}';
    }


}
