package service.impl;

import constant.AppConstants;
import model.parking.ParkingFloor;
import model.parking.ParkingSpace;
import model.parking.ParkingSpot;
import service.ISystemService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SystemService implements ISystemService {

    ParkingSpace parkingSpace;

    public SystemService(ParkingSpace parkingSpace){
        this.parkingSpace = parkingSpace;
    }

    @Override
    public ParkingFloor addParkingFloor(ParkingFloor parkingFloor) {
        List<ParkingFloor> parkingFloors = parkingSpace.getParkingFloors();
        if(parkingFloors==null){
            parkingFloors = new ArrayList<>();
        }
        parkingFloors.add(parkingFloor);

        parkingSpace.setParkingFloors(parkingFloors);
        return parkingFloor;
    }

    @Override
    public ParkingSpace removeParkingFloor(int floorNumber) {
        return null;
    }

    @Override
    public ParkingFloor addEntranceGate(int floorNumber, int gateNumber) {
        return null;
    }

    @Override
    public ParkingFloor addExitGate(int floorNumber, int gateNumber) {
        return null;
    }

    @Override
    public ParkingFloor removeEntranceGate(int floorNumber, int gateNumber) {
        return null;
    }

    @Override
    public ParkingFloor removeExitGate(int floorNumber, int gateNumber) {
        return null;
    }

    @Override
    public ParkingFloor getParkingInformation(int floorNumber) {
        return parkingSpace.getParkingFloors().stream().filter(parkingFloor -> parkingFloor.getFloorNumber()==floorNumber)
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public void showAllParkingsForFloor(ParkingFloor parkingFloor) {
        System.out.print(String.format("%-8s %-17s", AppConstants.SLOT_NO, AppConstants.REGISTRATION_NO));
        System.out.print("\n");
        for (ParkingSpot spot : parkingFloor.getParkingSpots()) {
            if (spot.getVehicle() != null) {
                System.out.print(String.format("%-8s %-1s", spot.getSpotNumber(), spot.getVehicle().getVehicleNumber()));
                System.out.print("\n");
            }

        }
    }
}
