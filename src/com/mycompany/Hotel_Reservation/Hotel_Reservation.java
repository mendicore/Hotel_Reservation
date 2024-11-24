package com.mycompany.hotel_reservation;

import com.mycompany.Currency.IDR;
import com.mycompany.Hotel_Room.*;

public class Hotel_Reservation {

    public static void main(String[] args) {
        Room[] rooms = {
            new Standard("F1-01"), new Standard("F1-02"), new Standard("F1-03"), new Suite("F1-04"), new Suite("F1-05"),
            new Standard("F1-06"), new Standard("F1-07"), new Suite("F1-08"), new Suite("F1-09"), new VIP("F1-10"),
            new Suite("F2-01"), new Suite("F2-02"), new Suite("F2-03"), new Standard("F2-04"), new Standard("F2-05"),
            new Suite("F2-06"), new Suite("F2-07"), new Standard("F2-08"), new Standard("F2-09"), new VIP("F2-10"),
        };
        
        for(Room room : rooms){
           System.out.printf("Room : %s\t, Number: %s\t, Avalilable? %b\t,Price: %s\n", 
                             room.getType(), room.getRoomNumber(), room.isIsAvailable(), IDR.Rupiah(room.getPrice()));
        }
        
        System.out.println();
        System.out.println(rooms[0].showFacilities());
        System.out.println(rooms[3].showFacilities());
        System.out.println(rooms[19].showFacilities());
        
        System.out.println();
        rooms[0].bookRoom("John", "23-10-2023", 10);
        rooms[4].bookRoom("Jane", "03-12-2025", 34);
        rooms[4].bookRoom("Ame", "01-01-2023", 11);
        rooms[19].bookRoom("Dio", "11-11-2031", 50);
        rooms[15].bookRoom("Joe", "01-01-2025", 4);
        rooms[15].bookRoom("Watson", "31-05-2024", 100);
        System.out.println();
        
        for(Room room : rooms){
           System.out.printf("Room : %s\t, Number: %s\t, Avalilable? %b\t,Price: %s\n", 
                             room.getType(), room.getRoomNumber(), room.isIsAvailable(), IDR.Rupiah(room.getPrice()));
        }
        
        System.out.println();
        String booker1 = "John";
        String num1 = "F1-01";
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(num1)) {
                if (room instanceof Standard) {
                    Standard s = (Standard) room;
                    s.addExtraBed();
                    System.out.println();
                    s.addWifi();
                    System.out.println();
                    System.out.println("Total Cost: "+ IDR.Rupiah(s.calculateTotalCost()));
                }
            }
        }
       
        System.out.println();
        String booker2 = "Dio";
        String num2 = "F2-10";
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(num2)) {  
                if (room instanceof VIP) {
                    VIP v = (VIP) room;
                    v.addExtraBed();
                    System.out.println();
                    v.addWifi();
                    System.out.println();
                    v.addGamingConsole();
                    System.out.println();
                    v.addMeal();
                    System.out.println();
                    v.buySpaPackage();
                    System.out.println();
                    System.out.println("Total Cost: " + IDR.Rupiah(v.calculateTotalCost()));
                    
                }
            }
        }
        
        System.out.println();
        String booker3 = "Ame";
        String num3 = "F1-05";
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(num3)) { 
                if (room instanceof Suite) {
                    Suite s = (Suite) room;
                    s.addGamingConsole();
                    System.out.println();
                    s.addMeal();
                    System.out.println();
                    System.out.println("Total Cost: "+ IDR.Rupiah(s.calculateTotalCost()));
                }
            }
        } 
    }
}
