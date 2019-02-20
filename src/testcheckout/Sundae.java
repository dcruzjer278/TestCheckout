/**********************************************************************
 * Name: Jeremy D'cruz
 * Assignment: TestCheckout
 * Date: 02/02/2019
 * Description: Write a program that will display a receipt of items for
 * a dessert shoppe which sells Candy by the pound, cookies by the dozen
 * ice cream and sundaes. This class sets the cost, type of sundae and 
 * receipt for the Sundae part of receipt.
 ************************************************************************/
package testcheckout;

/**
 *
 * @author Jeremy D'Cruz
 */
public class Sundae extends IceCream {
    // define variables for the type 
    private String type;
    private int sundae_Cost;
    
    public Sundae() {
        //default constructor
    }
    
    // constructor of Sundae class with four parameters
    public Sundae(String typeOfIceCream, int costOfIceCream, 
	String typeOfSundae, int costOfSundae) 
    {
        //gets the type of icecream and cost of icecream from its parent
        //class IceCream
	super(typeOfIceCream, costOfIceCream);
	this.type = typeOfSundae;
	this.sundae_Cost = costOfSundae;
    }
    
    // getCost method calculate the total cost and returns the total cost
    @Override
    public int getCost() {
	int total = super.getCost() + this.getSundae_Cost();      
        //return the total cost 
	return total;
    
    }//end of getCost method

    // returns the sundae type
    public String getSundaeType() {
        //st stands for Sundae type
        String st = this.getType() + " Sundae with ";
        
        //return the sundae type
	return st;
    
    }//end of getSundaeType method

    public String getSundaeIceCreamType() {
        //sict stands for sundae ice cream type
	String sict = super.getName();
        
        //return the sundae icecream type
	return sict;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the sundae_Cost
     */
    public int getSundae_Cost() {
        return sundae_Cost;
    }

    /**
     * @param sundae_Cost the sundae_Cost to set
     */
    public void setSundae_Cost(int sundae_Cost) {
        this.sundae_Cost = sundae_Cost;
    }
    
    
    
}//end of class
