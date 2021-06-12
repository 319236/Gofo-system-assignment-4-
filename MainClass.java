/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofo.system.playground;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASD
 */
public class MainClass {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Choice = "";
        String reply;
        String email, password, name, phoneNumber;
        int streetNumber;
        String streetName, city;
         AddressClass address = new AddressClass(9, "eldokki", "giza");
        PlaygroundOwnerClass playgroundOwner=  new PlaygroundOwnerClass("owner59@gmail.com","09876545", "ownername", "23456765456", address);

        PlaygroundClass playground= new PlaygroundClass( playgroundOwner) ;
        TimeSlot timeSlot = new   TimeSlot();
         eWalletClass eWalletClass= new  eWalletClass();
         /*
             PlaygroundOwnerClass ownerName ;String playgroundName, descriptionOfplayground;
             int bookingNumber;
             double pricePerHour;
             // public ArrayList<TimeSlot> availableTime;
             boolean playgroundActivated;
             static int counter = 0;
  
    */
  
     //AddressClass address;
  
   // private ArrayList<TimeSlot> availableTime;
   
    
    

   
    
   

        //while (true) {
            System.out.println(" Do you want to register as a player or playground owner?");

            Choice = scanner.nextLine();
            if (Choice.equalsIgnoreCase("player")) {

                System.out.println("Enter your email ");
                email = scanner.nextLine();
                System.out.println("Enter your password ");
                password = scanner.nextLine();
                System.out.println("Enter your name  ");
                name = scanner.nextLine();
                System.out.println("Enter your phoneNumber ");
                phoneNumber = scanner.nextLine();
                System.out.println("Enter your streetNumber ");
                streetNumber = scanner.nextInt();
                System.out.println("Enter your streetName ");
                streetName = scanner.nextLine();
                System.out.println("Enter your city ");
                city = scanner.nextLine();
                 address = new AddressClass(streetNumber, streetName, city);
                PlayerClass player = new PlayerClass(email, password, name, phoneNumber, address);
                System.out.println(" Do you want to book a playground  ? Y/N");

                reply = scanner.nextLine();
                if (reply.equalsIgnoreCase("y")) {
                          
                         player.bookPlayground(playground, timeSlot); 
                          eWalletClass.eWalletMenu();
                }
                else
                {
                                    System.out.println("Enter valid choice");

                }

            } else if (Choice.equalsIgnoreCase("playgroundowner")) {
                System.out.println("Enter your email ");
                email = scanner.nextLine();
                System.out.println("Enter your password ");
                password = scanner.nextLine();
                System.out.println("Enter your name  ");
                name = scanner.nextLine();
                System.out.println("Enter your phoneNumber ");
                phoneNumber = scanner.nextLine();
                System.out.println("Enter your streetNumber ");
                streetNumber = scanner.nextInt();
                System.out.println("Enter your streetName ");
                streetName = scanner.nextLine();
                System.out.println("Enter your city ");
                city = scanner.nextLine();

                 address = new AddressClass(streetNumber, streetName, city);
               playgroundOwner = new PlaygroundOwnerClass(email, password, name, phoneNumber, address);
              // while (true) {
                    System.out.println("\n1- Add a new Playground"
                            + 
                             "\n2- Accessing eWallet"
                            + "\n3- Logout");
                    Choice = scanner.nextLine();
                    if (Choice.equalsIgnoreCase("1")) {
                       timeSlot= new TimeSlot();
                       playground= new PlaygroundClass(playgroundOwner);
                        playgroundOwner.addPlayground(playground);
                       
                   
                    } else if (Choice.equalsIgnoreCase("2")) {
                        eWalletClass.eWalletMenu();
                    } else if (Choice.equalsIgnoreCase("3")) {
                       System.exit(0);
                    } else {
                        System.out.println("Enter valid Choice\n");
                    }
               // }
                System.out.println("\nLogging out ...");
            }
        }
 

}

