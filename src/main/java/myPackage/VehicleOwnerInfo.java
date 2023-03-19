/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

/**
 *
 * @author Hamdy
 */
public class VehicleOwnerInfo {
    private String vehicleOwnerName;
    private String vehicleOwnerPhone;

    public VehicleOwnerInfo(String vehicleOwnerName, String vehicleOwnerPhone) {
        this.vehicleOwnerName = vehicleOwnerName.toLowerCase();
        this.vehicleOwnerPhone = vehicleOwnerPhone.toLowerCase();
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName.toLowerCase();
    }

    public String getVehicleOwnerPhone() {
        return vehicleOwnerPhone;
    }

    public void setVehicleOwnerPhone(String vehicleOwnerPhone) {
        this.vehicleOwnerPhone = vehicleOwnerPhone.toLowerCase();
    }
    
}

