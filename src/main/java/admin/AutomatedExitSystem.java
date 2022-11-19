package admin;

import model.gate.ParkingExitGate;
import service.IFreeParkingService;

public class AutomatedExitSystem {
    private ParkingExitGate parkingExitGate;
    private IFreeParkingService freeParkingService;

    public AutomatedExitSystem(IFreeParkingService freeParkingService) {
        this.freeParkingService = freeParkingService;
    }

    public ParkingExitGate getParkingExitGate() {
        return parkingExitGate;
    }

    public void setParkingExitGate(ParkingExitGate parkingExitGate) {
        this.parkingExitGate = parkingExitGate;
    }

    public IFreeParkingService getFreeParkingService() {
        return freeParkingService;
    }

    public void setFreeParkingService(IFreeParkingService freeParkingService) {
        this.freeParkingService = freeParkingService;
    }
}
