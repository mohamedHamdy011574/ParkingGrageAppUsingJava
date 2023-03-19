/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import myPackage.EnumsAndConstants.VehicleType;

/**
 *
 * @author Hamdy
 */
public class MyInterface {
    private int exit = 1;
    private int exitApp = 1;
    private Scanner in = new Scanner(System.in);
    
    private int select=-1;
    private boolean flag = true;
 
    void menu()
    {
        System.out.println("Parking Lot System");
           
        // create Parking lot and the spots in it  40 motorbike/ 40 trucks / 120 cars / 100 van and total is 300
        ParkingLot myLot  = ParkingLot.getInstance();
        ParkingSpot [][]myspots = myLot.getSpots();
        
        System.out.println("Lets Create  First Admin account");
        
        String name ,phone,userName,password,address;
        while(true)
        {
            System.out.print("Name: ");  name=in.nextLine().toLowerCase();
            System.out.print("Phone: "); phone=in.nextLine();
            System.out.print("address: ");  address=in.nextLine().toLowerCase();
            System.out.print("User Name: ");  userName=in.nextLine().toLowerCase();
            System.out.print("Password: "); password = in.nextLine();
            if(myValidation.ValidAccountInfo(name,phone,address,userName,password,myLot)){
                Admin newAdmin = new Admin(userName, password, name, phone, address);
                myLot.setLotAdmin(newAdmin);
                break;
            }
            System.out.println("");
            System.out.println("Sorry, check your info and try again");
        }
        System.out.println("");
        System.out.println(" Now You Can Login ");
        

        int key =0;
        
        do{
            System.out.println("Enter userName and password");
            do { 
                
                System.out.print("User Name: ");
                userName = in.next().toLowerCase();
                System.out.print("Password: ");
                password = in.next().toLowerCase();
                if(myValidation.ValidAdminAccount(userName, password, myLot.getLotAdmin()))
                {
                     key = 1;
                     break;
                }
     
                else if( myValidation.ValidEmpolyeeAccount(userName, password,myLot.getAccounts()))
                {
                     key = 2;
                     break;
                }
                System.out.println("Sorry, Wrong password or email login agin");
            }while(key !=1 || key != 2);
            System.out.println("");
            if(key == 1)
            {
                Admin adminAcc =  myLot.getLotAdmin();
                int exitApp = AdminModel(myLot,adminAcc);
            }
            else if (key == 2)
            {
                Empolyee empolyeeAcc = myLot.getEmpolyeeAccount(userName);
                int exitApp = EmpolyeeModel(myLot,empolyeeAcc);
            }
            
        }while(exitApp != 0);
    }
    private  void deisplayAllSpots(ParkingSpot[][] myspots){
            System.out.println("     1      2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18    19    20");
            for (int i=0;i<myspots.length;i++){
                if(i < 9)
                    System.out.print((i+1)+":  ");
                else
                    System.out.print((i+1)+": ");
                for(int j=0;j<myspots[i].length;j++){
                    if(myspots[i][j].getStatus() == EnumsAndConstants.SpotStatus.ACTIVE)
                        System.out.print("[ f ] ");
                    else
                        System.out.print("[ - ] ");
                }
                System.out.println("");
            }
        }
        private  int AdminModel(ParkingLot myLot , Admin admin)
        {
            exit = 1;
            String name ,phone,userName,password,address;
            do{
                System.out.println("");
                System.out.println("1. Display All slots ");
                System.out.println("2. View Profile ");
                System.out.println("3. Update Profile");
                System.out.println("4. See All Employees");
                System.out.println("5. add Employee ");
                System.out.println("6. Remove Empolyee");
                System.out.println("7. see total number of car and the income");
                System.out.println("");
                
                flag = true;
               do{
                    System.out.print("Select what you want (press 0 to log out ) : ");
                    
                    select =in.nextInt();
                    in.nextLine();
                    
                    if(select == 0 || select == 1 || select == 2 || select == 3 || select == 4 || select == 5 || select == 6 || select == 7)
                        flag=false; 
                }while(flag);
              
                switch (select) {
                    case 0:
                        exit = 0;
                        break;
                    case 1:
                        deisplayAllSpots(myLot.getSpots());
                        break;
                    case 2:
                       admin.viewProfile();
                       break;
                    case 3:
                        admin.UpdateProfile();
                        break;
                        
                    case 4:
                        System.out.println("All Emolyee details");
                        System.out.println("");
                        for(int i=0;i<myLot.getAccounts().size();i++)
                        {
                            myLot.getAccounts().get(i).viewProfile();
                        }
                        break;
                    case 5:
                       boolean s1 = admin.addEmpolyee( createNewEmpolyee(myLot),myLot.getAccounts());
                       if(s1)
                            System.out.println("Adding successfully");
                       break;
                    case 6:
                        System.out.println("Enter the User Name");
                        userName = in.nextLine();
                         boolean s = admin.removeAccount(userName,myLot.getAccounts());
                        if(s)
                            System.out.println("removed successfully");
                        else
                            System.out.println("check the user name and try again , or add empolyee if there is no one");
                        break;
                    case 7:
                        System.out.println("Number of cars use our parkLot : "+ ParkingSpot.NumberOfVehiclesParkInSpots);
                        System.out.println("Total Income : "+ParkingSpot.totalMoneyFromSpots);
                        break;
                    
                }
                
            }while(exit != 0);
            return exit;
        }
        private  int EmpolyeeModel(ParkingLot myLot , Empolyee e){
            String vId = "";
            boolean success=false;
            exit=1;
            float cost= 0.0f;
            long duration;
            String name ,phone,userName,password,address;
            do{
                System.out.println("");
                System.out.println("1. Display All slots ");
                System.out.println("2. View Profile ");
                System.out.println("3. Add Vehicle To Spot");
                System.out.println("4. Remove Vehicle From Spot");
                System.out.println("");
                flag = true;
             do{
                    System.out.print("Select what you want (press 0 to log out ) : ");
                     select =in.nextInt();
                    in.nextLine();
                    
                    
                    if(select == 0 || select == 1 || select == 2 || select == 3 || select == 4 || select == 5)
                        flag=false; 
                }while(flag);
                
                switch (select) {
                    case 0:
                        exit = 0;
                        break;
                    case 1:
                        deisplayAllSpots(myLot.getSpots());
                        break;
                    case 2:
                       e.viewProfile();
                       break;
                    case 3:
                        if(!myLot.isFull()){
                            Vehicle newVehicle = createNewVehicle(myLot);
                            success = e.ParkIn(newVehicle, myLot.getSpots());
                            if(success)
                                System.out.println("parking done successfully");
                            break;
                        }
                        else{
                            System.out.println("Sorry Your Parking Lot is full");
                            break;
                        }
                    case 4:
                        do{
                            System.out.println("Enter the Vehicle id: ");
                            vId = in.nextLine().toLowerCase();
                            if(!myValidation.checkValidId(vId, myLot.getSpots()))
                                System.out.println("Wrong id or there is no vehicle in parkinglot with that id");
                            else
                                break;
                        }while(true);
                        ParkingSpot spots[][] = myLot.getSpots();
                        Vehicle spotVehicle = new Vehicle() ;
                        for(int i=0;i<spots.length;i++)
                        {
                            for(int j=0;j<spots[i].length;j++)
                            {
                                if(spots[i][j].getVehicle() !=  null && spots[i][j].getVehicle().getVehicleId().equals(vId))
                                {
                                   spotVehicle = spots[i][j].getVehicle();
                                }
                            }
                        }
                        
                        
                        success= e.ParkOut(vId, myLot.getSpots());
                        
                        long Minutes = TimeUnit.MILLISECONDS.toMinutes(spotVehicle.getDurationOfParking());
                      
                       System.out.println("Start Parking in "+spotVehicle.getStartParkingTime());
                       System.out.println("End Parking in "+spotVehicle.getEndParkingTime());  
                       
                       System.out.println("Duration in Hours "+ (float)Minutes/60); 
                       System.out.println("Duration in Minutes = "+ Minutes);
                       
                       System.out.println(" cost = "+ spotVehicle.getCostOfParkingInSpot());                        
                        
                        if(success){
                            System.out.println("parking end successfully");
                        }
                        break;

                }
                
            }while(exit != 0);
            return exit;
        }
        
        private  Empolyee createNewEmpolyee(ParkingLot myLot)
        {
            String name ,phone,userName,password,address;
            System.out.println("Enter the Empolyee details");
             while(true)
                {   
                System.out.print("Name: ");  name=in.nextLine().toLowerCase();
                System.out.print("Phone: "); phone=in.nextLine();
                System.out.print("address: ");  address=in.nextLine().toLowerCase();
                System.out.print("User Name: ");  userName=in.nextLine().toLowerCase();
                System.out.print("Password: "); password = in.nextLine();
                if(myValidation.ValidAccountInfo(name, phone, address, userName, password, myLot)){
                    Empolyee newEmpolyee = new Empolyee(userName, password, name, phone, address);
                    return newEmpolyee;
                }
                System.out.println("");
                System.out.println("Sorry, check your info and try agin");
           }
        }
        private Vehicle createNewVehicle(ParkingLot myLot)
        {
            String name ,phone,ownerName;
            
            String vId="";
            VehicleType vType = EnumsAndConstants.VehicleType.CAR ;
            String vModelYear="";
            int choose;
            
            System.out.println("Enter the vehical info");
           
               do{
                    System.out.print("Enter the Vehicle Id : ");
                    vId = in.nextLine().toLowerCase();
                 do{
                    System.out.print("Enter the Vheicle Type (1 for cars / 2 for vans / 3 for Truck / 4 for MotorBike ):");
                    
                    choose =in.nextInt();
                    in.nextLine();
                    
                    if(choose == 1 || choose == 2 || choose ==3 || choose ==4)
                        break;
                    else
                        System.out.println("Sorry , you enter wrong choise try again");
                    }while(true);
                    switch(choose)
                    {
                        case 1:
                            vType = EnumsAndConstants.VehicleType.CAR;
                            break;
                        case 2:
                            vType = EnumsAndConstants.VehicleType.VAN;
                            break;
                        case 3:
                            vType = EnumsAndConstants.VehicleType.TRUCK;
                            break;
                        case 4:
                            vType = EnumsAndConstants.VehicleType.MOTORBIKE;
                            break;
                    }
                    System.out.print("Enter the Vehical Model Year: ");
                    vModelYear = in.nextLine();
                    
                    System.out.print("Enter the owner Name: ");
                    ownerName = in.nextLine().toLowerCase();
                    
                    System.out.print("Enter the owner Phone: ");
                    phone = in.nextLine();
                    
                    
                    if(myValidation.ValidVehicleInfo(vId,  vModelYear, ownerName, phone, myLot.getSpots()))
                        break;
                
               }while( true);
               VehicleOwnerInfo ownerInfo = new VehicleOwnerInfo(ownerName, phone);
               Vehicle newVehicle = new Vehicle(vId, vType, vModelYear, ownerInfo);
               return newVehicle;
        }
        
        
}
