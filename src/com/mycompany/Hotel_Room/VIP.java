package com.mycompany.Hotel_Room;

import com.mycompany.Currency.IDR;
import com.mycompany.Facilities.*;

public class VIP extends Room implements Standard_Facilities, Suite_Facilities, VIP_Facilities {
    private final double extraBedPrice = 3000000;
    private final double mealPrice = 250000;
    private final double consolePrice = 2500000;
    private final double maidPrice = 5000000;
    private final double spaPrice = 2500000;
    private final double exclusiceAccessPrice = 10000000;
    
    private boolean extraBedAvailable;
    private boolean consoleRented;
    private boolean maidRented;
    private int spaCount;
    private boolean exclusiceAccess;
    
    
    public VIP(String roomNumber) {
        super("VIP", roomNumber, 40000000);
        this.extraBedAvailable = true;
        this.consoleRented = false;
        this.spaCount = 0;
        this.exclusiceAccess = false;
        
    }
    
    @Override
    public double calculateTotalCost(){
        double finalPrice = (price * stayTime);
         if(!extraBedAvailable){
             finalPrice += extraBedPrice;
         }
         
         if(consoleRented){
             finalPrice += consolePrice;
         }
         
         if(maidRented){
             finalPrice += maidPrice;
         }
         
         if(exclusiceAccess){
             finalPrice += exclusiceAccessPrice;
         }
         
         if(stayTime >= 7){
             finalPrice = finalPrice - (finalPrice * 0.1);
         }else if(stayTime >= 30){
             finalPrice = finalPrice - (finalPrice * 0.2);
         }
         
         return finalPrice;
    }

    @Override
    public String showFacilities() {
        return """
                VIP FACILITIES:
               - Exclusively designed space or themed room.
               - Premium bed (custom king-size).
               - Private lounge area within the room.
               - Luxury bathroom with jacuzzi or private sauna.
               - Access to a personal butler service.
               - Fully stocked mini bar (including premium alcoholic beverages).
               - Advanced technology facilities (smart TV, sound system, and smart controls).
               - Exclusive dining options (private breakfast or dinner).
               - Dedicated check-in and check-out services with no queue.
               - The most exclusive views (e.g., rooftop suite or penthouse).
               """;
    }
                
    @Override
    public void Discount() {
        if(stayTime >= 7){
            System.out.println("You got 10% discount.");
        }else if(stayTime >= 30){
            System.out.println("You got 20% discouunt.");
        }else{
            System.out.println("You need to stay atleast 7 days to get a discount.");
        }
    }

    @Override
    public void addExtraBed() {
        if(extraBedAvailable){
           System.out.printf("Room %s ordered extra bed.\nthe cost is %s.\n", roomNumber, IDR.Rupiah(extraBedPrice));
           this.extraBedAvailable = false;
        }else{
           System.out.printf("Room %s already ordered extra bed\n", roomNumber);
       }
    }

    @Override
    public void addMeal() {
       System.out.printf("Room %s ordered food.\nthe cost is %s.\n", roomNumber, IDR.Rupiah(mealPrice));
    }

    @Override
    public void addWifi() {
        System.out.printf("Room %s already have Wi-Fi.\n", roomNumber);
    }
    
    @Override
    public void addGamingConsole() {
         if (!consoleRented) {
            this.consoleRented = true;
            System.out.printf("Room %s rent a gaming console.\nthe cost is %s.\n ", roomNumber, IDR.Rupiah(consolePrice));
         } else {
            System.out.printf("Room %s is already rented a gaming console.\n", roomNumber);
        }
    }
        

    @Override
    public void hasLoungeAccess() {
         System.out.printf("Room %s already have Private lounge.\n", roomNumber);
    }
        
        
    @Override
    public void assignMaid() {
        if(maidRented){
           System.out.printf("Room %s rent a maid.\nthe cost is %s.\n", roomNumber, IDR.Rupiah(extraBedPrice));
           this.maidRented = true;
       }else{
           System.out.printf("Room %s already rent a maid\n", roomNumber);
       }
    }

    @Override
    public void buySpaPackage() {
        System.out.printf("Room %s buy spa package.\nthe cost is %s.\n", roomNumber, IDR.Rupiah(spaPrice));
        this.spaCount++;
    }
    
    @Override
    public void grantExclusiveEventAccess() {
        if(maidRented){
           System.out.printf("Room %s buy access to Exlusive event.\nthe cost is %s.\n", roomNumber, IDR.Rupiah(exclusiceAccessPrice));
           this.exclusiceAccess = true;
       }else{
           System.out.printf("Room %s already have access Exlusive event.\n", roomNumber);
        }
    }
    
}
