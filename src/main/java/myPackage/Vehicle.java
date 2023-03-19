/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import myPackage.EnumsAndConstants.VehicleType;

/**
 *
 * @author Hamdy
 */
public class Vehicle {
    private VehicleType type;
    private VehicleOwnerInfo ownerInfo;
    private String vehicleId;
    
    private String StartParkingTime;
    private String endParkingTime;
    
    private Long StartParkingTimeInMS;
    private long EndParkingTimeInMS;
    
    private float costOfParkingInSpot;
    
    private Long durationOfParking;
    
    private String vModelYear;
    
    public Vehicle(){};
    public Vehicle(String vehicleId,VehicleType type,String vMOdelyear, VehicleOwnerInfo ownerInfo ) {
        this.type = type;
        this.ownerInfo = ownerInfo;
        this.vehicleId = vehicleId.toLowerCase();
        
        this.StartParkingTime = "";
        this.endParkingTime = "";
        
        this.StartParkingTimeInMS = 0l;
        this.EndParkingTimeInMS = 0l;
        
        this.costOfParkingInSpot = 0.000000000000f;
        
        this.durationOfParking = 0l;
        
        this.vModelYear = vModelYear;
        
    }

    public void setvModelYear(String vModelYear) {
        this.vModelYear = vModelYear;
    }

    public String getvModelYear() {
        return vModelYear;
    }
    

    public float getCostOfParkingInSpot() {
        return costOfParkingInSpot;
    }

    public void setCostOfParkingInSpot(float costOfParkingInSpot) {
        this.costOfParkingInSpot = costOfParkingInSpot;
    }
    
    

    public Long getStartParkingTimeInMS() {
        return StartParkingTimeInMS;
    }

    public void setStartParkingTimeInMS(Long StartParkingTimeInMS) {
        this.StartParkingTimeInMS = StartParkingTimeInMS;
    }

    public long getEndParkingTimeInMS() {
        return EndParkingTimeInMS;
    }

    public void setEndParkingTimeInMS(long EndParkingTimeInMS) {
        this.EndParkingTimeInMS = EndParkingTimeInMS;
    }
    public String getStartParkingTime() {
        return StartParkingTime;
    }

    public void setStartParkingTime(String StartParkingTime) {
        this.StartParkingTime = StartParkingTime;
    }

    public String getEndParkingTime() {
        return endParkingTime;
    }

    public void setEndParkingTime(String endParkingTime) {
        this.endParkingTime = endParkingTime;
    }

    public long getDurationOfParking() {
        return durationOfParking;
    }

    public void setDurationOfParking(long durationOfParking) {
        this.durationOfParking = durationOfParking;
    }
    
    public void setType(VehicleType type) {
        
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public VehicleOwnerInfo getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(VehicleOwnerInfo ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId.toLowerCase();
    }
    
}

