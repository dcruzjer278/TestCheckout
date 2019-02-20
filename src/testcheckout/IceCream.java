/**********************************************************************
 * Name: Jeremy D'cruz
 * Assignment: TestCheckout
 * Date: 02/02/2019
 * Description: Write a program that will display a receipt of items for
 * a dessert shoppe which sells Candy by the pound, cookies by the dozen
 * ice cream and sundaes. This class sets the cost and receipt for the 
 * IceCream part of receipt.
 ************************************************************************/
package testcheckout;

/**
 *
 * @author Jeremy D'Cruz
 */
public class IceCream extends DessertItem 
{
    
    // define variable cost
    private int cost;
    
    public IceCream() {
        //default constructor
    }
    
    // IceCream constructor with two parameters
    public IceCream(String nameOfIceCream, int cst) {
        super(nameOfIceCream);
        this.cost = cst;
    }

    // getCost method returns the cost
    @Override
    public int getCost() 
    {
	return this.cost;
    
    }//end of getCost method
    
}//end of class
