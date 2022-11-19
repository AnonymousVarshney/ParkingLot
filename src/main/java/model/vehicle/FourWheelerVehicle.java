package model.vehicle;


public class FourWheelerVehicle extends Vehicle{

    public FourWheelerVehicle(String vehicleNumber) {
        super(vehicleNumber, VehicleCategory.FOURWHEELER);
    }

    @Override
    public Integer calculateFare(int noOfHours){
        if(noOfHours<=2)
            return 10;
        else{
            return 10+(10*(noOfHours-2));
        }
    }
}
