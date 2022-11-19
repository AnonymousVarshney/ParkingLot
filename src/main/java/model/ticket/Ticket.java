package model.ticket;

import model.parking.ParkingSpot;
import model.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private int parkingEntryGateNumber;
    private ParkingSpot parkingSpot;
    private TicketStatus ticketStatus;

    public Ticket(int ticketId, Vehicle vehicle,
                  int parkingEntryGateNumber, ParkingSpot parkingSpot, TicketStatus ticketStatus) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.parkingEntryGateNumber = parkingEntryGateNumber;
        this.parkingSpot = parkingSpot;
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public int getParkingEntryGate() {
        return parkingEntryGateNumber;
    }

    public void setParkingEntryGate(int parkingEntryGateNumber) {
        this.parkingEntryGateNumber = parkingEntryGateNumber;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", vehicle=" + vehicle +
                ", entryTime=" + entryTime +
                ", parkingEntryGateNumber=" + parkingEntryGateNumber +
                ", parkingSpot=" + parkingSpot +
                ", ticketStatus=" + ticketStatus +
                '}';
    }
}
