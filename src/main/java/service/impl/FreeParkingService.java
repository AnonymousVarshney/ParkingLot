package service.impl;

import model.ticket.Ticket;
import service.IFreeParkingService;

public class FreeParkingService implements IFreeParkingService {

    ParkingService parkingService;

    public FreeParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    @Override
    public Integer freeParking(Ticket ticket,int hours) {
        return parkingService.freeParking(ticket,hours);
    }
}
