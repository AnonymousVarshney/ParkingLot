import model.parking.ParkingSpace;
import org.junit.Test;

/**
 * Unit test.
 */
public class ParkingMainTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testMain() {

        String testCase="src/test/resources/Test2.txt";
            System.out.print(testCase+"\n");
            String[] args = new String[1];
            args[0] =testCase;
            ParkingLotMainApplication.main(args);
            ParkingSpace.getInstance().setParkingFloors(null);
            System.out.print("\n");

    }
    @Test
    public void testMain1() {

        String testCase="src/test/resources/Test3.txt";
            System.out.print(testCase+"\n");
            String[] args = new String[1];
            args[0] =testCase;
            ParkingLotMainApplication.main(args);
        ParkingSpace.getInstance().setParkingFloors(null);
            System.out.print("\n");


    }

    @Test
    public void testMain2() {

            String testCase="src/test/resources/Test4.txt";
            System.out.print(testCase+"\n");
            String[] args = new String[1];
            args[0] =testCase;
            ParkingLotMainApplication.main(args);
        ParkingSpace.getInstance().setParkingFloors(null);
            System.out.print("\n");

    }

    @Test
    public void checkingWhenParkingLotFull() {

        String testCase="src/test/resources/Test6.txt";
        System.out.print(testCase+"\n");
        String[] args = new String[1];
        args[0] =testCase;
        ParkingLotMainApplication.main(args);
        ParkingSpace.getInstance().setParkingFloors(null);
        System.out.print("\n");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testError2() {

        String testCase="src/test/resources/Test1.txt";
        System.out.print(testCase+"\n");
        String[] args = new String[1];
        args[0] =testCase;
        ParkingLotMainApplication.main(args);
        ParkingSpace.getInstance().setParkingFloors(null);
        System.out.print("\n");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testError3() {

        String testCase="src/test/resources/Test5.txt";
        System.out.print(testCase+"\n");
        String[] args = new String[1];
        args[0] =testCase;
        ParkingLotMainApplication.main(args);
        ParkingSpace.getInstance().setParkingFloors(null);
        System.out.print("\n");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testError4() {

        String testCase="src/test/resources/Test7.txt";
        System.out.print(testCase+"\n");
        String[] args = new String[1];
        args[0] =testCase;
        ParkingLotMainApplication.main(args);
        ParkingSpace.getInstance().setParkingFloors(null);
        System.out.print("\n");

    }




    @Test(expected = IllegalArgumentException.class)
    public void testError1(){

            String[] args = new String[0];
            ParkingLotMainApplication.main(args);
            System.out.print("\n");

    }


}
