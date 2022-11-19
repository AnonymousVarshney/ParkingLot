package service;

import model.ticket.Ticket;
import model.vehicle.Vehicle;

public interface IBookParkingService {
    // return ticket
    Ticket bookParking(int parkingGateNumber, Vehicle vehicle);
}
