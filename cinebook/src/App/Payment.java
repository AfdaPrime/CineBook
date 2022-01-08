/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author iwana
 */
public class Payment {
    
    public double ticketPrice;
    public double fnbPrice;
    public int ticketNumber;
    public int fnbNumber;

    public double Payment(double ticketPrice, double fnbPrice, int ticketNumber, int fnbNumber) {
        
        this.ticketPrice = ticketPrice;
        this.fnbPrice = fnbPrice;
        this.ticketNumber = ticketNumber;
        this.fnbNumber = fnbNumber;
        
        double sum = (this.ticketPrice*this.ticketNumber) + (this.fnbPrice*this.fnbNumber);
        
        return sum;
        
    }
}

