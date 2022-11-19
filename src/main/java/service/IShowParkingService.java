package service;

import admin.ParkingSystemAdministrator;
import model.ticket.Ticket;

public interface IShowParkingService {
    // returns cost
    public void showAllParkings(ParkingSystemAdministrator parkingSystemAdministrator);
}
