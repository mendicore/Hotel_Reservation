package com.mycompany.Hotel_Room;
import com.mycompany.Currency.IDR;
import com.mycompany.Facilities.Standard_Facilities;

public class Standard extends Room implements Standard_Facilities {
private final double extraBedPrice = 250000;
private final double mealPrice = 50000;
private final double wifiPrice = 150000;
private boolean extraBedAvailable;
private boolean wifiRented;

    public Standard(String roomNumber) {
        super("Standard", roomNumber, 500000);
        this.extraBedAvailable = true;
        this.wifiRented = false;
    }

    @Override
    public double calculateTotalCost(){
        double finalPrice = (price * stayTime);
            if(!extraBedAvailable){
                finalPrice += extraBedPrice;
            }

            if(wifiRented){
                finalPrice += wifiPrice;
            }

            if(stayTime >= 7){
                finalPrice = finalPrice - (finalPrice * 0.05);
            }

            return finalPrice;
        }

    @Override
    public String showFacilities(){
        return """
                STANDARD FACILITIES:
                - Double bed
                - Bathroom with a shower
                - AC
                - Standard TV
                - Small desk & Chair
                - Simple wardrobe
                """;
    }

    @Override
    public void Discount() {
        if(stayTime >= 7){
            System.out.println("You got 5% discount.");
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
        if (!wifiRented) {
            this.wifiRented = true;
            System.out.printf("Room %s rent a Wi-Fi.\nthe cost is %s.\n ", roomNumber, IDR.Rupiah(wifiPrice));
        } else {
            System.out.printf("Room %s is already rented a Wi-Fi.\n", roomNumber);
        }
    }
}
