/**********************************************************************
 * Name: Jeremy D'cruz
 * Assignment: TestCheckout
 * Date: 02/02/2019
 * Description: Write a program that will display a receipt of items for
 * a dessert shoppe which sells Candy by the pound, cookies by the dozen
 * ice cream and sundaes. This class allows the user to enter dessert 
 * items, clear items. get the total cost, the  tax and a String 
 * representation of the receipt of dessert items.
 ************************************************************************/
package testcheckout;

//add the import inorder to create an arraylist
import java.util.ArrayList;

/**
 *
 * @author Jeremy D'Cruz
 */
public class Checkout extends java.lang.Object {
    // create a ArrayList of DessertItem type
    private final ArrayList<DessertItem> dessItem;
    
    // Checkout constructor creates an instance of
    // checkout with an empty list of DessertItem
    public Checkout() {
      this.dessItem = new ArrayList<DessertItem>();
    }
    
    //clears the checkout to begin checking a new set of items
    public void clear() {
        this.dessItem.clear();
    }
    
    //enterItem add the dessert items into the list
    public void enterItem(DessertItem dessert) {
        this.dessItem.add(dessert);
    }
    
    // numberOfItems() returns the number of items in the list
    public int numberOfItems() {
        return dessItem.size();
    }
    
    // totalCost() returns the total of items in the list without tax
    public int totalCost() {
        //Initializes the total cost to 0
        int total_Cost = 0;
        
        //will loop through the arraylist of dessertitems while
        //adding to the cost each time
	for (DessertItem o : dessItem) {
	    total_Cost += o.getCost();
	}
        
        //return the total cost
	return total_Cost;
    }
    
    // totalTax() returns the total tax on items int the list
    public int totalTax() {
        //create a variable for the total tax which will store the
        //calculation for getting the tax
        double total_Tax = totalCost() * 
                        DessertShoppe.TAX_RATE * 0.01;
        
        //round the tax using Math.round
        int totalTaxInt = (int) Math.round(total_Tax);
        
        //return the total tax as an integer
	return totalTaxInt;
    }
    
    // toString() method returns a String represents 
    //a receipt for the current list of items
    @Override
    public java.lang.String toString() {
        //set a variable for storing the width of the receipt
	int receipt_Width = DessertShoppe.MAX_ITEM_NAME_SIZE 
        + DessertShoppe.COST_WIDTH;
        
        //set a variable for storing the length for the name of the store
        int name_Length = DessertShoppe.STORE_NAME.length();
        
        //set a centralize variable for bringing both the 
        //reciept with and name length to one place
	int centralize = (receipt_Width - name_Length) / 2;
		
        // display the title of shoppe with correct formatting
	String titleOfShoppe = "\n\n" + insertSpace(centralize);
	titleOfShoppe = titleOfShoppe + DessertShoppe.STORE_NAME 
        + "\n";
	    
        // display the --------------------
	String underscore = "" + insertSpace(centralize);
	for (int i = 0; i < name_Length; i++) {
		underscore = underscore + "-";
	}
	
        //skip two lines after the underscores are printed so that
        //there is a gap between the title and the dessert item info
        underscore += "\n\n";
	    
        // checkoutItem holds the list of item
	String checkoutItem = "";

        //use an enhanced for loop to iterate through each dessert item
	for (DessertItem di : dessItem) {
            //checks if the dessert item is an instance of type Cookie
	    if (di instanceof Cookie) {
                // store cost of cookies into cost variable
                String cost = "" + di.getCost();
                
                //sp stands for the space required for the Cookie info
                int sp = receipt_Width - di.getName().length() - 
                    cost.length() - 1;
                checkoutItem = checkoutItem + 
                     //cast dessertItem to a Cookie in calculation
                    ((Cookie) di).getListPrice() + "\n" + 
                di.getName() + insertSpace(sp) + 
                        
                //this will call the cents2dollarsAndCents method from
                //dessert shoppe so that conversion can be made from 
                //format being in cents to cents and dollars
                DessertShoppe.cents2dollarsAndCents(di.getCost()) + "\n";

	    } 
               
            //checks if the dessert item is an instance of type Candy
            else if (di instanceof Candy) {
                // store cost of candy into cost variable
                String cost = "" + di.getCost();
                
                //sp stands for the space required for the Candy info
                int sp = receipt_Width - di.getName().length() 
                    - cost.length() - 1;
                                  //cast dessertItem to a Candy in calculation
                checkoutItem = checkoutItem + ((Candy) di).getListPrice() 
                    + "\n" + di.getName() + insertSpace(sp)
		    + DessertShoppe.cents2dollarsAndCents(di.getCost()) + "\n";

	    } 
            
            //checks if the dessert item is an instance of type Sundae
            else if (di instanceof Sundae) {
                // store cost of Sundae into cost variable
                String cost = "" + di.getCost();
                
                //sp stands for the space required for the Sundae info
                int sp = receipt_Width - 
                ((Sundae) di).getSundaeIceCreamType().length() 
                - cost.length() - 1;
                checkoutItem = checkoutItem 
                + ((Sundae) di).getSundaeType()
                        //cast dessertItem to a Sundae in calculation
                + "\n" + ((Sundae) di).getSundaeIceCreamType()
                + insertSpace(sp) 
                + DessertShoppe.cents2dollarsAndCents(di.getCost()) + "\n";

            } 
            
            //checks if the dessert item is an instance of any other dessert 
            //type
            else {
                // store cost of other items into cost variable
                //use String concatenation
                String cost = "" + di.getCost();
                
                //sp stands for the space required for the other items info
                int sp = receipt_Width - di.getName().length() 
                    - cost.length() - 1;
                checkoutItem = checkoutItem + di.getName() 
                    + insertSpace(sp) + 
                DessertShoppe.cents2dollarsAndCents(di.getCost())
                + "\n";
            }//end of else statement
            
        }//end of for loop
        
        // calculate the total cost with total tax method added on 
        //then store in grand_Total
	int grand_Total = totalCost() + totalTax();  
        
        //concatenate the totalTax method to a String
	String strTax = "" + totalTax();
        
        //concatenate the grand total to a String
	String strgrand_Total = "" + grand_Total;
        
        //display the Tax and store in tax variable with correct formatting
        //by using the insertSpace method
	String tax = "\nTax" + insertSpace(receipt_Width - 3 
                - strTax.length() - 1)
	+ DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n";
	
        //display the Total Cost and store in tax variable with correct 
        //formatting by using the insertSpace method
        String total = "Total Cost" + insertSpace(receipt_Width - 10
        - strgrand_Total.length() - 1)
	+ DessertShoppe.cents2dollarsAndCents(grand_Total) + "\n";

	// Concatenate titleOfShoppe, underscore, checkoutItem, 
        //tax, and total to return the grand total
	return titleOfShoppe + underscore + checkoutItem + tax + total; 
    
    }//end of toString

    // insertSpace() method separate items with space
    private String insertSpace(int x) {
        //create a str variable for storing a space
	String str = "";
        
        //each time loop runs a space will be added to the string and then
        //returned
	for (int i = 0; i < x; i++) {
	    str += " ";
	}
        
        //return the String for storing space
	return str;
    
    }//end of insertSpace method
    
}//end of Checkout class
