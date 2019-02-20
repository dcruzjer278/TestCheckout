/**********************************************************************
 * Name: Jeremy D'cruz
 * Assignment: TestCheckout
 * Date: 02/02/2019
 * Description: Write a program that will display a receipt of items for
 * a dessert shoppe which sells Candy by the pound, cookies by the dozen
 * ice cream and sundaes. This class sets the cost and receipt for the 
 * Candy part of receipt.
 ************************************************************************/
package testcheckout;

/**
 *
 * @author Jeremy D'Cruz
 */
public class Candy extends DessertItem{
    //declare instance variables for the weight and price per pound
    private double weight;
    private int pricePerPound;
    
    // constructor of Candy class
    public Candy() {
        // calling super() method
        super();
       
        // initialize the variables
	this.pricePerPound = -1;
	this.weight = -1;
    }
    
    // override constructor with three parameters
    public Candy(String name, double weight, double pricePerPound) {
        //inherits the name from its parent Candy
        super(name);
        this.pricePerPound = (int)pricePerPound;
        this.weight = weight;
        
    }
    
    // calculate the cost by getCost() method
    @Override
    public int getCost() {
         
        //if the weight and the pricePerPound does not -1 then
        //calculate and return the total cost as an integer
        if (this.weight != -1 && this.pricePerPound != -1) {
	    double cost = (this.pricePerPound * 1.0) * this.weight;
	    int costInt = (int) Math.round(cost);
	    return costInt;
	} 
        
        //if there is a price or weight set that does equal -1
        //display that the price or quantity has not been set for the
        //cookie and reset the cost to 0
        else {
	    System.out.println("Price and/or weight has not been set for "
	    + this.name + ". Cost returned is $0.");
	    int cost = 0;
	    return cost;
        }
        
    }//end of getCost method
    
    
    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the pricePerPound
     */
    public double getPricePerPound() {
        return pricePerPound;
    }

    /**
     * @param pricePerPound the pricePerPound to set
     */
    public void setPricePerPound(int pricePerPound) {
        this.pricePerPound = pricePerPound;
    }
    
    // 2.25 lbs. @ 3.99 /lb.
    // returns the list of price with items
    public String getListPrice() {
	String s = this.weight + " lbs. @ " +
	DessertShoppe.cents2dollarsAndCents(this.pricePerPound) +
	" /lb.";
	return s;
    
    }//end of getListPrice
    
    
}//end of Candy class
