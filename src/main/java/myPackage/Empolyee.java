/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Hamdy
 */
public class Empolyee extends AccountInfo{

    public Empolyee(String userName, String password, String name, String phone, String address) {
        super(userName, password, name, phone, address);
    }
    
    
    public boolean ParkIn(Vehicle customerVehicle,ParkingSpot[][] spots)
    {
       
            String startTime = "";
            
            EnumsAndConstants.VehicleType  vType = customerVehicle.getType();
            boolean flag =false;

            if(vType.equals(EnumsAndConstants.VehicleType.CAR)){
                for(int i=2;i<spots.length;i++)
                {
                    for(int j=0;j<spots[i].length;j++)
                    {
                        if(spots[i][j].getStatus().equals(EnumsAndConstants.SpotStatus.ACTIVE))
                        {
                            if(spots[i][j].getLength() >= 2f && spots[i][j].getWidth() >= 1f )
                            {
                                flag = spots[i][j].assignVehicle(customerVehicle);
                                if(flag){
                                    long timeNow = System.currentTimeMillis();
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                    LocalDateTime now = LocalDateTime.now();
                                    startTime = now.format(dtf);
                                    customerVehicle.setStartParkingTime(startTime);
                                    customerVehicle.setStartParkingTimeInMS(timeNow);
                                    return flag;
                                    
                                }
                            }

                       }
                    }

                }
            }
            if(vType.equals(EnumsAndConstants.VehicleType.TRUCK)){
                for(int i=13;i<spots.length;i++)
                {
                    for(int j=0;j<spots[i].length;j++)
                    {
                        if(spots[i][j].getStatus().equals(EnumsAndConstants.SpotStatus.ACTIVE))
                        {
                            if(spots[i][j].getLength() >= 5.8f && spots[i][j].getWidth() >= 2f )
                            {
                                flag = spots[i][j].assignVehicle(customerVehicle);
                                if(flag){
                                    long timeNow = System.currentTimeMillis();
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                    LocalDateTime now = LocalDateTime.now();
                                    startTime = now.format(dtf);
                                    customerVehicle.setStartParkingTime(startTime);
                                    customerVehicle.setStartParkingTimeInMS(timeNow);
                                    return flag;
                                }
                            }

                       }
                    }

                }
            }
            if(vType.equals(EnumsAndConstants.VehicleType.VAN)){
                for(int i=8;i<spots.length;i++)
                {
                    for(int j=0;j<spots[i].length;j++)
                    {
                        if(spots[i][j].getStatus().equals(EnumsAndConstants.SpotStatus.ACTIVE))
                        {
                            if(spots[i][j].getLength() >= 2.7f && spots[i][j].getWidth() >= 1.7f )
                            {
                                flag = spots[i][j].assignVehicle(customerVehicle);
                                if(flag){
                                    long timeNow = System.currentTimeMillis();
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                    LocalDateTime now = LocalDateTime.now();
                                    startTime = now.format(dtf);
                                    customerVehicle.setStartParkingTime(startTime);
                                    customerVehicle.setStartParkingTimeInMS(timeNow);
                                    return flag;
                                }
                            }

                       }
                    }

                }
            }
            if(vType.equals(EnumsAndConstants.VehicleType.MOTORBIKE)){
                for(int i=0;i<spots.length;i++)
                {
                    for(int j=0;j<spots[i].length;j++)
                    {
                        if(spots[i][j].getStatus().equals(EnumsAndConstants.SpotStatus.ACTIVE))
                        {
                            if(spots[i][j].getLength() >= 0.34f && spots[i][j].getWidth() >= 0.13f )
                            {
                                flag = spots[i][j].assignVehicle(customerVehicle);
                                if(flag){
                                    long timeNow = System.currentTimeMillis();
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                    LocalDateTime now = LocalDateTime.now();
                                    startTime = now.format(dtf);
                                    customerVehicle.setStartParkingTime(startTime);
                                    customerVehicle.setStartParkingTimeInMS(timeNow);
                                    return flag;
                                }
                            }

                       }
                    }

                }
            }
            return flag;
        
    }
    
    public boolean ParkOut(String ID , ParkingSpot[][] spots)
    {
        for(int i=0 ;i<spots.length;i++)
        {
            String endTime = "";
            for(int j=0;j<spots[i].length;j++)
            {
                if(spots[i][j].getVehicle() != null && spots[i][j].getVehicle().getVehicleId().equals(ID))
                {
                   long timeNow = System.currentTimeMillis();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    endTime = now.format(dtf);
                    spots[i][j].getVehicle().setEndParkingTime(endTime);
                    spots[i][j].getVehicle().setEndParkingTimeInMS(timeNow);
                    return  spots[i][j].removeVehicle();
                        
                   
                }
            }
        }
        return false;
    }
    
    
    
}

