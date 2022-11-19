package admin;

import model.gate.ParkingEntryGate;
import service.IBookParkingService;

public class AutomatedEntrySystem {
    private ParkingEntryGate parkingEntryGate;
    private IBookParkingService bookParkingService;

    public AutomatedEntrySystem(IBookParkingService bookParkingService) {
        this.bookParkingService = bookParkingService;
    }

    public ParkingEntryGate getParkingEntryGate() {
        return parkingEntryGate;
    }

    public void setParkingEntryGate(ParkingEntryGate parkingEntryGate) {
        this.parkingEntryGate = parkingEntryGate;
    }

    public IBookParkingService getBookParkingService() {
        return bookParkingService;
    }

    public void setBookParkingService(IBookParkingService bookParkingService) {
        this.bookParkingService = bookParkingService;
    }
}
