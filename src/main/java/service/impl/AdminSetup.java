package service.impl;

import admin.AutomatedEntrySystem;
import admin.AutomatedExitSystem;
import admin.ParkingSystemAdministrator;
import model.gate.ParkingEntryGate;
import model.gate.ParkingExitGate;
import model.parking.ParkingFloor;
import model.parking.ParkingSpace;
import model.parking.ParkingSpot;
import model.vehicle.VehicleCategory;

import java.util.ArrayList;
import java.util.List;

public class AdminSetup {

    public ParkingSystemAdministrator createParkingSystemAdministrator(int noOfParkings){

        ParkingSpace parkingSpace = ParkingSpace.getInstance();

        SystemService systemService = new SystemService(parkingSpace);

        TicketService ticketService = new TicketService();
        ParkingService parkingService = new ParkingService(parkingSpace, ticketService);

        AutomatedEntrySystem automatedEntrySystem =new AutomatedEntrySystem(new BookParkingService(parkingService));
        AutomatedExitSystem automatedExitSystem = new AutomatedExitSystem(new FreeParkingService(parkingService));

        ParkingSystemAdministrator parkingSystemAdministrator =
                new ParkingSystemAdministrator(systemService,automatedEntrySystem,automatedExitSystem,
                        ticketService);

        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for(int i=1;i<=noOfParkings;i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleCategory.FOURWHEELER, true));
        }

        List<ParkingEntryGate> parkingEntryGates = new ArrayList<>();
        parkingEntryGates.add(new ParkingEntryGate(1, 1, true, false));

        List<ParkingExitGate> parkingExitGates = new ArrayList<>();
        parkingExitGates.add(new ParkingExitGate(1, 2, false, false));

        ParkingFloor parkingFloor = new ParkingFloor(1, parkingSpots, parkingEntryGates, parkingExitGates);
        parkingSystemAdministrator.addParkingFloors(parkingFloor);

        return parkingSystemAdministrator;
    }
}
