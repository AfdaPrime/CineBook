/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author iwana
 */
public class payment {
    
    public double ticketPrice;
    public double fnbPrice;
    public int ticketNumber;
    public int fnbNumber;

    public payment(double ticketPrice, double fnbPrice, int ticketNumber, int fnbNumber) {
        
        this.ticketPrice = ticketPrice;
        this.fnbPrice = fnbPrice;
        this.ticketNumber = ticketNumber;
        this.fnbNumber = fnbNumber;
               
    }
    
    public void displayPrice(){
        double sum = (this.ticketPrice*this.ticketNumber)+(this.fnbPrice*this.fnbNumber);
        System.out.printf("\nThe total payment is %.2f\n", sum);
    }
}

