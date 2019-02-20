/**********************************************************************
 * Name: Jeremy D'cruz
 * Assignment: TestCheckout
 * Date: 02/02/2019
 * Description: Write a program that will display a receipt of items for
 * a dessert shoppe which sells Candy by the pound, cookies by the dozen
 * ice cream and sundaes. This class sets the cost, number of cookies and
 * receipt for the Cookie part of receipt.
 ************************************************************************/
package testcheckout;

/**
 *
 * @author Jeremy D'Cruz
 */
public class Cookie extends DessertItem{
    //declare instance variables for both the number and the
    //price per dozen
    private int number;
    private int pricePerDozen;
    
    // default constructor of class 
    public Cookie() {
	super();
        //initialize the number and pricePerDozen both to -1
	this.number = -1;
	this.pricePerDozen = -1;
    }
  
    // override constructor with three parameters
    public Cookie(String nameOfCookie, int quantity, int price) {
        //will get the name of the cookie from its parent
        super(nameOfCookie);
        this.number = quantity;
        this.pricePerDozen = price;
    }
    
    
    @Override
    public int getCost() {
        //if the pricePerDozen or the number of cookies is equal to -1 then
        //display that the price or quantity has not been set for the
        //cookie and reset the cost to 0
        if (this.getPricePerDozen() == -1 || this.number == -1) {
	    System.out.println("Price and/or quantity has not been set for " 
                    + this.name + ". Cost returned is $0.");
	    int cost = 0;
	    return cost;
	} 
        
        //if there is a price or quantity set that does not equal -1 
        //then calculate and return the total cost as an integer
        else {
	    double cost = this.getPricePerDozen() * 1.0 / 12 * this.number;
	    int costInt = (int) Math.round(cost);
	    return costInt;
	}
    
    }//end of getCost method
    

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * @param pricePerDozen the pricePerDozen to set
     */
    public void setPricePerDozen(int pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }
    
     /**
     * @return the pricePerDozen
     */
    public int getPricePerDozen() {
        return pricePerDozen;
    }
    
    // getListPrice() method returns the list of price with items
    public String getListPrice() {
        //will display the quantity portion of receipt for cookies
	String list_price = this.number + " @ " + 
        DessertShoppe.cents2dollarsAndCents(this.getPricePerDozen()) 
        + " /dz.";       
        //return the list price
	return list_price;
    
    }//end of getListPrice

   
}//end of Cookie class
