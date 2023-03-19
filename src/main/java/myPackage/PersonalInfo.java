
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

/**
 *
 * @author Hamdy
 */
public abstract class PersonalInfo {
       
         private String name;
         private String address;
         private String phone;

        public PersonalInfo(String name, String phone, String address) {
            this.name = name.toLowerCase();
            this.phone = phone.toLowerCase();
            this.address = address.toLowerCase();
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name.toLowerCase();
        }
        
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address.toLowerCase();
        }
        
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone.toLowerCase();
        }


         

    }
    

