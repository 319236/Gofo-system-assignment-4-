/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofo.system.playground;

/**
 *
 * @author ASD
 */
public class AddressClass {
    
    private int streetNumber;
   
    private String streetName;
   
    private String city;

    /**
     *
     * @param streetNumber
     * @param streetName
     * @param city
     */
    public AddressClass(int streetNumber, String streetName, String city) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
       
        this.city = city;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " +  ", " + city;
    }

    /**
     *
     * @return
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the street number of the address
     * @param streetNumber the new street number
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     *
     * @return
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     *
     * @param streetName
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }




    /**
     * Gets the city of the address
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
