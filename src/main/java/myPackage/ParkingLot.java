
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;
import java.util.ArrayList;
import myPackage.EnumsAndConstants.SpotStatus;
/**
 *
 * @author Hamdy
 */
public class ParkingLot {
    
    private ArrayList<Empolyee> accounts ;
    private Admin lotAdmin ;
    
    private ParkingSpot[][] spots ;
    
    private String address;
   
    private int totalNumberOfSpots;
    private int totalNumberOfEmpolyees;
    
    private int carSpots;
    private int actualCarSpots;
    private int truckSpots;
    private int actualTruckSpots;
    private int vanSpots;
    private int actualVanSpots;
    private int MotorbikeSpots;
    private int actualMotorbikeSpots;
    
    private int totalNumberOfCars;
    private float totalIncome;


    private  ParkingLot() {
        this.address = "2 Mohamed Mohamod street madintNassr";
        
        this.totalNumberOfSpots = 300;
        this.spots = new ParkingSpot[15][20];
        createSpots();
        
        this.totalNumberOfEmpolyees = 0;
        this.accounts = new ArrayList(5);
        
        this.lotAdmin = null;
        
        this.carSpots = 120;
        this.actualCarSpots = this.carSpots;
        this.truckSpots = 40;
        this.actualTruckSpots = this.truckSpots;
        this.vanSpots = 100;
        this.actualVanSpots = this.vanSpots;
        this.MotorbikeSpots = 40;
        this.actualMotorbikeSpots = this.MotorbikeSpots;
        
        this.totalNumberOfCars = 0;
        this.totalIncome = 0;
        
    }
     
    private static ParkingLot parkingLot = null;
     
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
          parkingLot  = new ParkingLot();
        }
        return parkingLot;
    }
    
    private void createSpots(){
        
        for(int i=0;i<spots.length;i++)
        {
            for(int j=0;j<spots[i].length;j++)
            {
                spots[i][j]= new ParkingSpot(0,0,5);
                if(i<=1){ 
                    if(i==0){
                        spots[i][j].setLength(0.34f);
                        spots[i][j].setWidth(0.13f);
                    }
                    if(i==1){
                        spots[i][j].setLength(0.5f);
                        spots[i][j].setWidth(0.5f);
                    }
                } 
                if(i>1 && i<=7){ 
                    if(i>=2 && i<=4){
                        spots[i][j].setLength(2f);
                        spots[i][j].setWidth(1f);
                    }
                    if(i>=5 && i<=7){
                        spots[i][j].setLength(2.5f);
                        spots[i][j].setWidth(1.5f);
                    }
                }     
                if(i>7 && i<=12){ 
                    if(i>=8 && i<=9 ){
                        spots[i][j].setLength(2.7f);
                        spots[i][j].setWidth(1.7f);
                    }
                    if(i==10 ){
                        spots[i][j].setLength(2.9f);
                        spots[i][j].setWidth(1.9f);
                    }
                    if(i>=11 && i<=12 ){
                        spots[i][j].setLength(3.1f);
                        spots[i][j].setWidth(3.1f);
                    }
                }
                if(i>12 && i<=14){ 
                    if(i==13){
                        spots[i][j].setLength(5.8f);
                        spots[i][j].setWidth(2f );
                    }
                    if(i==14){
                        spots[i][j].setLength(6.5f);
                        spots[i][j].setWidth(3f);
                    }
                }     
            }
        }
    }
    
    private int calcRemaningSpots (int start , int end)
    {
        int count=0;
        for(int i= start ; i <= end ; i++){
            for(int j = 0 ; j < 20 ; j++)
            {
                if(spots[i][j].getVehicle() == null && spots[i][j].getStatus() == EnumsAndConstants.SpotStatus.ACTIVE)
                {
                    count++;
                }
            }
           
        } 
        return count;
                
    }
    
    public Admin getLotAdmin() {
        return lotAdmin;
    }

    public void setLotAdmin(Admin lotAdmin) {
        this.lotAdmin = lotAdmin;
    }
    
    public ArrayList<Empolyee> getAccounts() {
        return accounts;
    }

    public ParkingSpot[][] getSpots() {
        return spots;
    }

    public String getAddress() {
        return address;
    }

    public int getTotalNumberOfSpots() {
        return totalNumberOfSpots;
    }

    public int getTotalNumberOfEmpolyees() {
        return accounts.size();
    }

    public int getCarSpots() {
        return carSpots;
    }

    public int getActualCarSpots() {
        return calcRemaningSpots(2, 7);
    }

    public int getTruckSpots() {
        return truckSpots;
    }

    public int getActualTruckSpots() {
        return calcRemaningSpots(13,14);
    }

    public int getVanSpots() {
        return vanSpots;
    }

    public int getActualVanSpots() {
        return calcRemaningSpots(8, 12);
    }

    public int getMotorbikeSpots() {
        return MotorbikeSpots;
    }

    public int getActualMotorbikeSpots() {
        return calcRemaningSpots(0, 1);
    }

    public int getTotalNumberOfCars() {
        return ParkingSpot.NumberOfVehiclesParkInSpots;
    }

    public float getTotalIncome() {
        return ParkingSpot.totalMoneyFromSpots;
    }
    
    public Empolyee getEmpolyeeAccount(String userName)
    {
        userName = userName.toLowerCase();
        
        for(int i=0;i<accounts.size();i++)
        {
            if(accounts.get(i).getUserName().equals(userName)){
                return accounts.get(i);
            }
        }
        return null;
    }

    public boolean isFull()
    {
        for(int i=0 ;i<spots.length;i++)
        {
            for(int j=0 ;j<spots[i].length;j++)
            {
                if(spots[i][j].getStatus() == SpotStatus.ACTIVE)
                {
                    return false;
                }
            }
        }
        return true;
    }


    
    
    
  }

