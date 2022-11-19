package service.impl;

import model.parking.ParkingSpot;
import model.ticket.Ticket;
import model.ticket.TicketStatus;
import model.vehicle.Vehicle;

import java.util.*;

public class TicketService {

    Map<String, Ticket> ticketsCollection = new HashMap<>();

    public Ticket getTicket(int parkingEntryGateNumber, ParkingSpot parkingSpot, Vehicle vehicle) {
        Ticket ticket = new Ticket(new Random().nextInt(), vehicle, parkingEntryGateNumber, parkingSpot, TicketStatus.BOOKED);
        ticketsCollection.put(vehicle.getVehicleNumber(), ticket);
        return ticket;
    }

    public Ticket checkIfTicketExists(String vehicleNumber){
       return ticketsCollection.get(vehicleNumber);
    }

    public Integer getParkingFare(Ticket ticket,int noOfHours) {

        int farePrice = ticket.getVehicle().calculateFare(noOfHours);
        ticketsCollection.remove(ticket.getVehicle().getVehicleNumber());
        return farePrice;
    }

    public Map<String, Ticket> getTicketsCollection(){
        return ticketsCollection;
    }
}
