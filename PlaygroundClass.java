
package gofo.system.playground;

import java.util.ArrayList;

/**
 *
 * @author ASD
 */
public class PlaygroundClass {
    private PlaygroundOwnerClass ownerName;
  
    private String playgroundName;
   
  
    private String descriptionOfplayground;
  
    private AddressClass address;
  
    private ArrayList<TimeSlot> availableTime;
   
    private int bookingNumber;
  
    private double pricePerHour;
    

   
    private boolean playgroundActivated;
    private static int counter = 0;

    /**
     *
     * @param owner
     */
    public PlaygroundClass(PlaygroundOwnerClass owner) {
        this.ownerName = owner;
        playgroundName = "playgroundName";
        descriptionOfplayground = "";
        pricePerHour = 0;
        bookingNumber = ++counter;
       
        availableTime = new ArrayList<>();
        playgroundActivated = false;
       
    }

    /**
     *
     * @param timeSlot
     * @param player
     * @return
     */
    public boolean bookPlayground(TimeSlot timeSlot, PlayerClass player) {
        if (!this.isPlaygroundActivated()) {
            return false;
        }
        double totalPrice;
        if (timeSlot.getStartingHour() < timeSlot.getEndingHour())
            totalPrice = pricePerHour * (timeSlot.getEndingHour() - timeSlot.getStartingHour());
        else
            totalPrice = pricePerHour * ((timeSlot.getEndingHour() + 24) - timeSlot.getStartingHour());
        if (player.getEwallet().getBalance() <= totalPrice) {
            return false;
        }
        for (int i = 0; i < availableTime.size(); i++)
            if (availableTime.get(i).equals(timeSlot)) {
                if (availableTime.get(i).isDone())
                    return false;
                else {
                    availableTime.get(i).book(player.getName());
                    player.getEwallet().transferMoney(totalPrice, ownerName);
                    return true;
                }
            }
        return false;
    }

    /**
     *
     * @param timeslot
     */
    public void setAvailableTime(ArrayList<TimeSlot> timeslot) {
        availableTime.clear();
        availableTime.addAll(timeslot);
    }
 
    /**
     *
     * @return
     */
    public ArrayList<TimeSlot> getAvailability() {
        return availableTime;
    }

    /**
     *
     * @return
     */
    public ArrayList<TimeSlot> getAvailableTime() {
        return availableTime;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String result =
                "=============================================\n" +
                "playgroundName: " + playgroundName + '\n' +
                        "description: " + descriptionOfplayground + '\n' +
                        "bookingNumber: " + bookingNumber + '\n' +
                        "pricePerHour: " + pricePerHour + '\n' +
                       
                        "activated: " + playgroundActivated + '\n' +
                        "Address: " + address.toString() + '\n' +
                        "Availability: " + '\n';
        for (int i = 0; i < availableTime.size(); i++) {
            result += availableTime.get(i).toString();
            result += '\n';
        }
        result += "\n========================================";
        return result;
    }

    /**
     *
     * @return
     */
    public String getPlaygroundName() {
        return playgroundName;
    }

    /**
     *
     * @param playgroundName
     */
    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    /**
     * Gets the descriptionOfplayground of the playground
     * @return the descriptionOfplayground of the playground
     */
    public String getDescriptionOfplayground() {
        return descriptionOfplayground;
    }

    /**
     * Sets the descriptionOfplayground of the playground
     * @param descriptionOfplayground the new descriptionOfplayground of the playground
     */
    public void setDescriptionOfplayground(String descriptionOfplayground) {
        this.descriptionOfplayground = descriptionOfplayground;
    }

    /**
     * Gets the booking number of the playground
     * @return the booking number of the playground
     */
    public int getBookingNumber() {
        return bookingNumber;
    }

    /**
     * Gets the price per hour of the playground
     * @return the price per hour of the playground
     */
    public double getPricePerHour() {
        return pricePerHour;
    }

    /**
     * Sets the price per hour of the playground
     * @param pricePerHour the new price per hour
     */
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    /**
     *
     * @return
     */
    public boolean isPlaygroundActivated() {
        return playgroundActivated;
    }

    /**
     *
     * @param playgroundActivated
     */
    public void setPlaygroundActivated(boolean playgroundActivated) {
        this.playgroundActivated = playgroundActivated;
    }

    /**
     *
     * @return
     */
    public AddressClass getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(AddressClass address) {
        this.address = address;
    }

 
  
    
}
