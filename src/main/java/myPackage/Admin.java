/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Hamdy
 */
public class Admin extends AccountInfo{
    
    public Admin(String userName, String password, String name, String phone, String address) {
        super(userName, password, name, phone, address);
    }
    
    public boolean addEmpolyee(Empolyee account , ArrayList<Empolyee> accounts)
    {
        int size = accounts.size();
        for(int i = 0 ; i < size ; i++)
        {
            if(accounts.get(i).getUserName().equals(account.getUserName()))
            {
                return false;
            }
        }
        accounts.add(account);
            
        return true;
    }
    
    public boolean removeAccount(String uName , ArrayList<Empolyee> accounts)
    {
        uName = uName.toLowerCase();
        int size = accounts.size();
        for(int i = 0 ; i < size ; i++)
        {
            if(accounts.get(i).getUserName().equals(uName))
            {
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }
    public void UpdateProfile()
    {
        Scanner in = new Scanner(System.in);
        int select=-1;
        boolean flag = true;
        String update ="";
        
        
        while(true){
            
            this.viewProfile();
            flag = true;
            while(flag){
                System.out.print("choose what yo want to update ( press 0 for exit ) :");
              select =in.nextInt();
                    in.nextLine();
                    
                if(select == 0 || select == 1 || select == 2 || select == 3 || select == 4 || select == 5)
                    flag=false; 
            }
           int number=0;
            do{
                switch(select)
                {
                    case 0:
                        return;
                    case 1:
                        System.out.print("Enter the  Name: ");
                        update = in.nextLine();
                        number = 1;
                        break;
                    case 2:
                        System.out.print("Enter the phone: ");
                        update = in.nextLine();
                        number = 2;
                        break;                
                    case 3:
                        System.out.print("Enter the address: ");
                        update = in.nextLine();
                        number = 3;
                        break;                
                    case 4:
                        System.out.print("Enter the userName: ");
                        update = in.nextLine();
                        number = 4;
                        break;                
                    case 5:
                        System.out.print("Enter the password: ");
                        update = in.nextLine();
                        number = 5;
                        break;                
                }
                if(number == 1){
                    if( myValidation.ValidOnUpdate(update,this.getPhone() ,this.getAddress(), this.getUserName(), this.getPassword(),myLot)){
                        this.setName(update);
                        break;
                        }   
                }
                if(number == 2){
                   if(myValidation.ValidOnUpdate(this.getName(),update ,this.getAddress(), this.getUserName(), this.getPassword(),myLot) ){
                        this.setPhone(update);
                        break;
                        }                    
                }
                if(number == 3){
                   if(myValidation.ValidOnUpdate(this.getName(),this.getPhone() ,update, this.getUserName(), this.getPassword(),myLot) ){
                        this.setAddress(update);
                        break;
                        }                    
                }
                if(number == 4){
                   if(myValidation.ValidOnUpdate(this.getName(),this.getPhone() ,this.getAddress(), update , this.getPassword(),myLot)){
                        this.setUserName(update);
                        break;
                        }                      
                }
                if(number == 5){
                   if(myValidation.ValidOnUpdate(this.getName(),this.getPhone() ,this.getAddress(), this.getUserName() , update ,myLot)){
                        this.setPassword(update);
                        break;
                        }                      
                }
        
                if(!myValidation.ValidOnUpdate(this.getName(),this.getPhone() ,this.getAddress(), this.getUserName(), this.getPassword(),myLot))
                        System.out.println("Wrong update , try again");
                else
                    break;
                
            }while(true);
            
        }
    
    }
        
}

