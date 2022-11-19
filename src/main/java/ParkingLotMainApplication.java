import admin.ParkingSystemAdministrator;
import model.parking.ParkingSpot;
import model.ticket.Ticket;
import model.vehicle.FourWheelerVehicle;
import model.vehicle.Vehicle;
import service.impl.AdminSetup;
import service.impl.TicketService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParkingLotMainApplication {

    public static void main(String[] args) {

        if(args==null || args.length==0){
            throw new IllegalArgumentException("No File Name found");
        }

        try
        {
            ParkingSystemAdministrator parkingSystemAdministrator =null;
            TicketService ticketService =null;

            File file=new File(args[0]);    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;
            while((line=br.readLine())!=null)
            {
                if(line.contains("create")){

                    String[] createArr=line.split(" ");
                    AdminSetup adminSetup=new AdminSetup();
                    parkingSystemAdministrator=adminSetup.createParkingSystemAdministrator(Integer.valueOf(createArr[1]));
                    ticketService=parkingSystemAdministrator.getTicketService();
                    System.out.print("Created parking lot with "+createArr[1]+" slots");

                }else if(line.contains("park")){
                    String[] parkArr=line.split(" ");
                    Vehicle vehicle = new FourWheelerVehicle(parkArr[1]);

                    if(null==parkingSystemAdministrator){
                        System.out.print("Parking has not been setup");
                        break;
                    }

                    Ticket ticket = parkingSystemAdministrator.getAutomatedEntrySystem()
                            .getBookParkingService().bookParking(1, vehicle);
                    if(ticket!=null)
                         System.out.print("Allocated slot number: "+ticket.getParkingSpot().getSpotNumber());
                    else
                        System.out.print("Sorry, parking lot is full");
                }else if(line.contains("leave")){
                    String[] leaveArr=line.split(" ");
                    if(null==parkingSystemAdministrator){
                        System.out.print("Parking has not been setup");
                        break;
                    }
                    Ticket ticket=ticketService.checkIfTicketExists(leaveArr[1]);
                    if(ticket!=null){
                        Integer cost = parkingSystemAdministrator.getAutomatedExitSystem().
                                getFreeParkingService().freeParking(ticket,Integer.valueOf(leaveArr[2]));
                        System.out.print("Registration Number "+leaveArr[1] +" from Slot "+ticket.getParkingSpot().getSpotNumber()+
                                " has left with Charge "+cost);
                    }else{
                        System.out.print("Registration Number " + leaveArr[1] + " not found");
                    }


                }else if(line.contains("status")){
                    if(null==parkingSystemAdministrator){
                        System.out.print("Parking has not been setup");
                        break;
                    }
                    System.out.print(String.format("%-8s %-17s", "Slot No.","Registration No.\n"));
                    for(ParkingSpot spot:parkingSystemAdministrator.getFloorInformation(1).getParkingSpots()){
                        if(spot.getVehicle()!=null) {
                            System.out.print(String.format("%-8s %-1s", spot.getSpotNumber(), spot.getVehicle().getVehicleNumber()));
                            System.out.print("\n");
                        }

                    }
                }

                System.out.print("\n");
            }
            fr.close();    //closes the stream and release the resources

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Input format is incorrect , please contact System Administrator");
            throw new IllegalArgumentException(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.print("Some exception has occurred allotting parking , " +
                    "please contact System Administrator");
            //e.printStackTrace();
        }
    }
}
