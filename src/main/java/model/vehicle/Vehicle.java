package model.vehicle;

public abstract class Vehicle {

    private String vehicleNumber;
    private VehicleCategory vehicleCategory;

    public Vehicle(String vehicleNumber, VehicleCategory vehicleCategory){
        this.vehicleNumber = vehicleNumber;
        this.vehicleCategory = vehicleCategory;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }

  /*  Charge applicable is $10 for the first 2 hours and
    $10 for every additional hour.
*/
    public abstract Integer calculateFare(int noOfHours);
}
