package model.vehicle;

/*
Extension of Vehicle abstract class , more implementation can be added
also different vehicle can have different fare calculation algorithm.
 */
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
