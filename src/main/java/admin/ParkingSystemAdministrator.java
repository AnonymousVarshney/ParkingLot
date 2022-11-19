package admin;

import model.parking.ParkingFloor;
import service.ISystemService;
import service.impl.TicketService;

/*
This would be used to handle any admin related work like adding floors or parking slots
Also this is used to get instance of entry gate system , exit gate system , and ticket generation service
*/
public class ParkingSystemAdministrator{
    private ISystemService iSystemService;
    private AutomatedEntrySystem automatedEntrySystem;
    private AutomatedExitSystem automatedExitSystem;
    private TicketService ticketService;

    public ParkingSystemAdministrator(ISystemService systemService,
                                      AutomatedEntrySystem automatedEntrySystem,
                                      AutomatedExitSystem automatedExitSystem,
                                      TicketService ticketService) {
        this.iSystemService = systemService;
        this.automatedEntrySystem=automatedEntrySystem;
        this.automatedExitSystem=automatedExitSystem;
        this.ticketService=ticketService;
    }

    public void addParkingFloors(ParkingFloor parkingFloor){
        this.iSystemService.addParkingFloor(parkingFloor);
    }

    public void removeParkingFloor(int floorNumber){
        this.iSystemService.removeParkingFloor(floorNumber);
    }

    public void addEntranceGate(int floorNumber, int gateNumber){
        this.iSystemService.addEntranceGate(floorNumber, gateNumber);
    }

    public void addExitGate(int floorNumber, int gateNumber){
        this.iSystemService.addExitGate(floorNumber, gateNumber);
    }

    public void removeEntranceGate(int floorNumber, int gateNumber){
        this.iSystemService.removeEntranceGate(floorNumber, gateNumber);
    }

    public void removeExitGate(int floorNumber, int gateNumber){
        this.iSystemService.removeExitGate(floorNumber, gateNumber);
    }

    public ParkingFloor getFloorInformation(int floorNumber) {
        return iSystemService.getParkingInformation(floorNumber);
    }

    public AutomatedEntrySystem getAutomatedEntrySystem() {
        return automatedEntrySystem;
    }


    public AutomatedExitSystem getAutomatedExitSystem() {
        return automatedExitSystem;
    }

    public TicketService getTicketService() {
        return ticketService;
    }
}
