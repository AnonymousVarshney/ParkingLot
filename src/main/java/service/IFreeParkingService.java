package service;

import model.ticket.Ticket;

public interface IFreeParkingService{
    // returns cost
    public Integer freeParking(Ticket ticket,int hours);
}
