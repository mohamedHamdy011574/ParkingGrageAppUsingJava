/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;



import java.util.concurrent.TimeUnit;
import myPackage.EnumsAndConstants.SpotStatus;

/**
 *
 * @author Hamdy
 */
public class ParkingSpot {
    private float width;
    private float length;
    private Vehicle vehicle;
    private SpotStatus status;
    private float spotFees;
    
   
    static float totalMoneyFromSpots;
    static int NumberOfVehiclesParkInSpots;
    
    public ParkingSpot(float width, float length, float spotFees) {
        this.width = width;
        this.length = length;
        this.vehicle = null;
        this.status = SpotStatus.ACTIVE;
        this.spotFees = spotFees;
    }
    
    
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public float getSpotFees() {
        return spotFees;
    }

    public void setSpotFees(float spotFees) {
        this.spotFees = spotFees;
    }
    
    public boolean assignVehicle(Vehicle vehicle) {
        if(this.vehicle == null){
            this.vehicle = vehicle;
            status = SpotStatus.INACTIVE;
            NumberOfVehiclesParkInSpots++;
            return true;
        }
        return false;
    }
    public boolean removeVehicle() {
       if(this.vehicle != null){
            long Minutes;
            this.vehicle.setDurationOfParking(this.vehicle.getEndParkingTimeInMS() - this.vehicle.getStartParkingTimeInMS() );
            Minutes = TimeUnit.MILLISECONDS.toMinutes(this.vehicle.getDurationOfParking());
            this.vehicle.setCostOfParkingInSpot((float)(spotFees/60)*Minutes);
            totalMoneyFromSpots += (spotFees/60)*Minutes;
            this.vehicle = null;
            status = SpotStatus.ACTIVE;
            return true;
       }
       return false;     
    }
    
}
