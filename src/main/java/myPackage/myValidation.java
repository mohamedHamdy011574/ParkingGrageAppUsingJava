/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.util.ArrayList;
import myPackage.EnumsAndConstants.VehicleType;

/**
 *
 * @author Hamdy
 */
public class myValidation {
       static boolean checkValidId(String vId , ParkingSpot[][] mySpots)
        {
            boolean flag;
            vId = vId.toLowerCase();
            for(int i=0;i<vId.length();i++){
                if((vId.charAt(i) >= 97 && vId.charAt(i) <= 122) || (vId.charAt(i) >= 48 && vId.charAt(i) <= 57))
                {
                    flag = true; 
                }
                else{
                    flag=false;
                    return flag;
                }
            }
            for (int i = 0; i < mySpots.length; i++) {
                for (int j = 0; j < mySpots[i].length; j++) {
                    
                    if( mySpots[i][j].getVehicle() != null && mySpots[i][j].getVehicle().getVehicleId().equals(vId))
                    {
                        return true;
                    }
                }
            }
               return false;
        
        }
        static boolean ValidAdminAccount(String uName ,String uPassword ,Admin admin)
        {
            uName = uName.toLowerCase();
            uPassword = uPassword.toLowerCase();
            
            if(admin.getUserName().equals(uName) && admin.getPassword().equals(uPassword)){
                return true;
            }
            return false;
        }
        static  boolean ValidEmpolyeeAccount(String uName ,String uPassword ,ArrayList<Empolyee> accounts)
        {
            uName = uName.toLowerCase();
            uPassword =uPassword.toLowerCase();
            
            int size = accounts.size();
            for(int i=0;i<size;i++)
            {
                if(accounts.get(i).getUserName().equals(uName))
                {
                    if(accounts.get(i) instanceof Empolyee)
                    {
                        if(accounts.get(i).getPassword().equals(uPassword))
                            return true;
                    }
                }
            }
            return false;
        }
        
        static boolean ValidOnUpdate(String name,String phone,String address,String userName,String password ,ParkingLot myLot){
            boolean flag = false , flag2 = false;
             for(int i=0;i<myLot.getAccounts().size();i++)
            {
                if(myLot.getAccounts().get(i).getUserName().equals(userName) || myLot.getAccounts().get(i).getPhone().equals(phone) )
                    return false;
            }
            
                for(int i=0;i<name.length();i++){
                    if(name.charAt(i) < 97 || name.charAt(i) > 122  ){ return false; }
                }
                for(int i=0;i<phone.length();i++){
                    if(phone.charAt(i) < 48 || phone.charAt(i) > 57 ){ return false; }
                }  
                for(int i=0;i<address.length();i++){
                    if((address.charAt(i) >= 97 && address.charAt(i) <= 122) || (address.charAt(i) >= 48 && address.charAt(i) <= 57) || (address.charAt(i) == 32) )
                        flag = true; 
                    else{
                        flag=false;
                        break;
                    }
                }
                for(int i=0;i<userName.length();i++){
                    if((userName.charAt(i) >= 97 && userName.charAt(i) <= 122) || (userName.charAt(i) >= 48 && userName.charAt(i) <= 57) )
                        flag2 = true; 
                    else{
                        flag2=false;
                        break;
                    }
                }
                for(int i=0;i<password.length();i++){
                    if(password.charAt(i) < 48 || password.charAt(i) > 57 ){ return false; }
                }
            if(flag == true && flag2 == true)
                return true;
            else
                return false;
            
        }
        static boolean ValidAccountInfo(String name,String phone,String address,String userName,String password ,ParkingLot myLot)
        {
            boolean flag = false , flag2 = false;
            
            if ((myLot.getLotAdmin() != null && userName .equals( myLot.getLotAdmin().getUserName())) || (myLot.getLotAdmin() != null && phone.equals(myLot.getLotAdmin().getPhone())))
                return false;
            
            
            for(int i=0;i<myLot.getAccounts().size();i++)
            {
                if(myLot.getAccounts().get(i).getUserName().equals(userName) || myLot.getAccounts().get(i).getPhone().equals(phone) )
                    return false;
            }
            
                for(int i=0;i<name.length();i++){
                    if(name.charAt(i) < 97 || name.charAt(i) > 122  ){ return false; }
                }
                for(int i=0;i<phone.length();i++){
                    if(phone.charAt(i) < 48 || phone.charAt(i) > 57 ){ return false; }
                }  
                for(int i=0;i<address.length();i++){
                    if((address.charAt(i) >= 97 && address.charAt(i) <= 122) || (address.charAt(i) >= 48 && address.charAt(i) <= 57) || (address.charAt(i) == 32) )
                        flag = true; 
                    else{
                        flag=false;
                        break;
                    }
                }
                for(int i=0;i<userName.length();i++){
                    if((userName.charAt(i) >= 97 && userName.charAt(i) <= 122) || (userName.charAt(i) >= 48 && userName.charAt(i) <= 57) )
                        flag2 = true; 
                    else{
                        flag2=false;
                        break;
                    }
                }
                for(int i=0;i<password.length();i++){
                    if(password.charAt(i) < 48 || password.charAt(i) > 57 ){ return false; }
                }
            if(flag == true && flag2 == true)
                return true;
            else
                return false;
        }
        static boolean ValidVehicleInfo(String vId ,String vModelYear,String name,String phone , ParkingSpot[][] mySpots)
        {       
            
            boolean flag;
            
            for(int i=0;i<vId.length();i++){
                if((vId.charAt(i) >= 97 && vId.charAt(i) <= 122) || (vId.charAt(i) >= 48 && vId.charAt(i) <= 57))
                {
                    flag = true; 
                }
                else{
                    flag=false;
                    return flag;
                }
            }
            for (int i = 0; i < mySpots.length; i++) {
                for (int j = 0; j < mySpots[i].length; j++) {
                    
                    if( mySpots[i][j].getVehicle() != null && mySpots[i][j].getVehicle().getVehicleId().equals(vId))
                    {
                        return false;
                    }
                }
            }
           

            for(int i=0;i<name.length();i++){
                if(name.charAt(i) < 97 || name.charAt(i) > 122 ){ return false; }
            }
            for(int i=0;i<phone.length();i++){
                if(phone.charAt(i) < 48 || phone.charAt(i) > 57 ){ return false; }
            }  
            for(int i=0;i<vModelYear.length();i++){
                if(vModelYear.charAt(i) < 48 || vModelYear.charAt(i) > 57 ){ return false; }
            } 
            
            return true;

        }
}
