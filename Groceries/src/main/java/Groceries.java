
/**
 * @author Vilasini Sarveswara
 *
 */
public class Groceries {
	private String groceryName;
	private String groceryQuantity;
	
	public Groceries() {
		
	}
	
	public Groceries(String groceryName, String groceryQuantity) {
		this.groceryName = groceryName;
		this.groceryQuantity = groceryQuantity;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	public String getGroceryQuantity() {
		return groceryQuantity;
	}

	public void setGroceryQuantity(String groceryQuantity) {
		this.groceryQuantity = groceryQuantity;
	}
	
		
	@Override
	public String toString() {
		return this.groceryName + " of " + this.groceryQuantity + " is available";
	}
	
}
