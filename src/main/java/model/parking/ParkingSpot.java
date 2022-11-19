package model.parking;

import model.vehicle.Vehicle;
import model.vehicle.VehicleCategory;

public class ParkingSpot {
    private Integer spotNumber;
    private Vehicle vehicle;
    private VehicleCategory vehicleCategory;
    private boolean isSpaceAvailableForParking;

    public ParkingSpot(Integer spotNumber, VehicleCategory vehicleCategory, boolean isSpaceAvailableForParking) {
        this.spotNumber = spotNumber;
        this.vehicleCategory = vehicleCategory;
        this.isSpaceAvailableForParking = isSpaceAvailableForParking;
    }

    public void freeTheParkingSpot(){
        this.isSpaceAvailableForParking = true;
        this.vehicle = null;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public boolean isSpaceAvailableForParking() {
        return isSpaceAvailableForParking;
    }

    public void setSpaceAvailableForParking(boolean spaceAvailableForParking) {
        isSpaceAvailableForParking = spaceAvailableForParking;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", vehicle=" + vehicle +
                ", vehicleCategory=" + vehicleCategory +
                ", isSpaceAvailableForParking=" + isSpaceAvailableForParking +
                '}';
    }
}
