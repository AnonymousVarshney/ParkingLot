import admin.ParkingSystemAdministrator;
import constant.AppConstants;
import constant.ErrorConstants;
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
            throw new IllegalArgumentException(ErrorConstants.FILE_NOT_FOUND);
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
                if(line.contains(AppConstants.CREATE)){

                    String[] createArr=line.split(" ");
                    AdminSetup adminSetup=new AdminSetup();
                    parkingSystemAdministrator=adminSetup.createParkingSystemAdministrator(Integer.valueOf(createArr[1]));
                    ticketService=parkingSystemAdministrator.getTicketService();
                    System.out.print(AppConstants.CREATED_PARKING_SLOT+createArr[1]+AppConstants.SLOTS);

                }else if(line.contains(AppConstants.PARK)){
                    String[] parkArr=line.split(" ");
                    Vehicle vehicle = new FourWheelerVehicle(parkArr[1]);

                    if(null==parkingSystemAdministrator){
                        throw new IllegalArgumentException(ErrorConstants.PARKING_SPACE_NOT_SETUP);
                    }

                    Ticket ticket = parkingSystemAdministrator.getAutomatedEntrySystem()
                            .getBookParkingService().bookParking(1, vehicle);
                    if(ticket!=null)
                         System.out.print(AppConstants.ALLOCATED_SLOT+ticket.getParkingSpot().getSpotNumber());
                    else
                        System.out.print(AppConstants.FULL_PARKING_LOT);
                }else if(line.contains(AppConstants.LEAVE)){
                    String[] leaveArr=line.split(" ");
                    if(null==parkingSystemAdministrator){
                        throw new IllegalArgumentException(ErrorConstants.PARKING_SPACE_NOT_SETUP);
                    }
                    Ticket ticket=ticketService.checkIfTicketExists(leaveArr[1]);
                    if(ticket!=null){
                        Integer cost = parkingSystemAdministrator.getAutomatedExitSystem().
                                getFreeParkingService().freeParking(ticket,Integer.valueOf(leaveArr[2]));
                        System.out.print(AppConstants.REGISTRATION_NUMBER+leaveArr[1] +" from Slot "+ticket.getParkingSpot().getSpotNumber()+
                                AppConstants.HAS_LEFT_CHARGE+cost);
                    }else{
                        System.out.print(AppConstants.REGISTRATION_NUMBER + leaveArr[1] + " not found");
                    }


                }else if(line.contains(AppConstants.STATUS)){
                    if(null==parkingSystemAdministrator){
                        throw new IllegalArgumentException(ErrorConstants.PARKING_SPACE_NOT_SETUP);
                    }
                    parkingSystemAdministrator.showAllParkingsForFloor(parkingSystemAdministrator.getFloorInformation(1));

                }

                System.out.print("\n");
            }
            fr.close();    //closes the stream and release the resources

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.print(ErrorConstants.INCORRECT_INPUT_FORMAT);
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage()+"\n");
            throw new IllegalArgumentException(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.print(ErrorConstants.SYSTEM_EXCEPTION);
            //e.printStackTrace();
        }
    }
}
