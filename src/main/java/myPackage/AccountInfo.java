/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.util.Scanner;

/**
 *
 * @author Hamdy
 */
public abstract class AccountInfo  extends PersonalInfo{
       private String userName;
       private String password;
       protected ParkingLot myLot = ParkingLot.getInstance();

    
    public AccountInfo(String userName, String password, String name, String phone, String address) {
        super(name, phone, address);
        this.userName = userName.toLowerCase();
        this.password = password.toLowerCase();
        
    }
    
    public String getUserName() {
            return userName;
        }

    public void setUserName(String userName) {
            this.userName = userName.toLowerCase();
        }

    public String getPassword() {
            return password;
        }

    public void setPassword(String password) {
            this.password = password.toLowerCase();
        }
    public void viewProfile(){
            System.out.println("");
            System.out.println("AccountInfo{ name = " +getName()+ ", phone = " +getPhone()+", address = " +getAddress()+ ", userName = " +userName+", password = " + password + '}');
            System.out.println("");
    }
    
    
    
}
    


