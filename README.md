Following application is a command line application or script reads the commands to run an automated parking system and do the tasks.

Pre-requisites :
1. maven should be installed. Following article can be referred to setup maven :
https://mkyong.com/maven/how-to-install-maven-in-windows/

2. Java 8 should be available.
It can be installed by following the process here :
https://mkyong.com/java/how-to-set-java_home-on-windows-10/

4. Go to cmd and go to the project directory and run :
mvn clean install

This will build the project and execute all the underlying test cases that are 
present under src/test/java folder and test files under src/test/resources.

4. Above command will also create class files and jar of the project which 
can be used to execute the java code from the command line.

5. 
D:\ParkingLot>java -jar target/ParkingLot-1.jar "src/main/resources/Test.txt"

"src/main/resources/Test.txt" -> Location of the file if it is in resources folder

OR 

D:\ParkingLot>java -jar target/ParkingLot-1.jar "D:\ParkingLot\src\main\resources\Test.txt"

"D:\ParkingLot\src\main\resources\Test.txt" -> Fully Qualified path of the file


6. This project can also be imported to Intellij as a maven project.
File -> Project From Existing Sources -> Select Directory (select maven while importing)

ASSUMPTIONS

7. In case parking has not been created the message "Parking has not been set up" is outputted.

8. No slots are printed that do not have a vehicle allotted to them. 
Exp test case: Test4.txt file output is :

src/test/resources/Test4.txt
Created parking lot with 6 slots
Slot No. Registration No.

9. Design is Set for a Single Floor , single entry gate and single exit gate right now but more 
   can be added. 

10. Solution is extensible to different type of vehicle and different type of parking spaces for them,
    and logic of cost of different vehicle and their parking spaces can be different. (Can be done
    by extending the Vehicle class).


