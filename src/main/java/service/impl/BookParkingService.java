package service.impl;

import model.ticket.Ticket;
import model.vehicle.Vehicle;
import service.IBookParkingService;

public class BookParkingService implements IBookParkingService {

    ParkingService parkingService;

    public BookParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    @Override
    public Ticket bookParking(int parkingEntryGateNumber, Vehicle vehicle) {
        return parkingService.bookParking(parkingEntryGateNumber, vehicle);
    }
}
