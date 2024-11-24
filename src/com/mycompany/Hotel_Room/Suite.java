package com.mycompany.Hotel_Room;

import com.mycompany.Currency.IDR;
import com.mycompany.Facilities.*;

public class Suite extends Room implements Standard_Facilities, Suite_Facilities{
    private final double extraBedPrice = 250000;
    private final double mealPrice = 50000;
    private final double consolePrice = 150000;;
    private final double loungePrice = 100000; 
    private boolean extraBedAvailable;
    private boolean consoleRented;
    private boolean LoungeAccess;
    
    public Suite(String roomNumber) {
        super("Suite",roomNumber, 4500000);
        this.extraBedAvailable = true;
        this.consoleRented = false;
        this.LoungeAccess = false;
        
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
         
         if(LoungeAccess){
             finalPrice += loungePrice;
         }
         
         if(stayTime >= 7){
             finalPrice = finalPrice - (finalPrice * 0.05);
         }else if(stayTime >= 30){
             finalPrice = finalPrice - (finalPrice * 0.1);
         }
         
         return finalPrice;
    }

    @Override
    public String showFacilities() {
        return """
                SUITE FACILITES:
                - Larger space (sometimes includes a separate living room).
                - King-size bed.
                - Private bathroom with a bathtub and shower.
                - More luxurious furniture (sofa, work desk).
                - Large flat-screen TV with premium channels.
                - Mini bar and coffee/tea maker.
                - Bathrobe and slippers.
                - 24-hour room service.
                - Better view (if available).
                - Premium or high-speed Wi-Fi.
                - Additional amenities such as a safe, iron, or hairdryer.
               """;         
    }    
    
    @Override
    public void Discount() {
        if(stayTime >= 7){
            System.out.println("You got 5% discount.");
        }else if(stayTime >= 30){
            System.out.println("You got 10% discouunt.");
        }else{
            System.out.println("You need to stay atleast 7 days to get a discount.");
        }
    }
             
    @Override
    public void addExtraBed() {
         if(extraBedAvailable){
           System.out.printf("Room %s ordered extra bed.\nthe cost is %s.\n\n", roomNumber, IDR.Rupiah(extraBedPrice));
           this.extraBedAvailable = false;
       }else{
           System.out.printf("Room %d already ordered extra bed\n", roomNumber);
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
        if(!LoungeAccess) {
            this.LoungeAccess = true;
            System.out.printf("Room %s buy lounge acces.\nthe cost is %s.\n ", roomNumber, IDR.Rupiah(loungePrice));
        } else {
            System.out.printf("Room %s is already have access to lounge.\n", roomNumber);
        }
    }
    
}
    
