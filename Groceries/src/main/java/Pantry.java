import java.util.HashMap;
import java.util.Map;

public class Pantry {

	private Map<Groceries,String> groceryShelfMap = new HashMap<Groceries, String>();

	public Pantry() {

	}

	public Pantry(Map<Groceries,String> groceryMap) {
		this.groceryShelfMap = groceryMap;
	}


	public void getAvailabiltyOfGrocery(String groceryName) {
		boolean available = false;
		for(Map.Entry<Groceries,String> groceryMap : groceryShelfMap.entrySet()) {
			if( groceryMap.getKey().getGroceryName().equalsIgnoreCase(groceryName)) {
				System.out.println(groceryName + " of " + groceryMap.getKey().getGroceryQuantity() +" is available on " +
						groceryMap.getValue());
						available = true;
						break;
				 }
		}
		if(!available) {
			System.out.println("Sorry, " +groceryName +	" is not in the grocery management system!");
		}
	}
	
	public void removeGroceryFromSystem(String groceryName) {
		boolean available = false;
		for(Map.Entry<Groceries,String> groceryMap : groceryShelfMap.entrySet()) {
			if( groceryMap.getKey().getGroceryName().equalsIgnoreCase(groceryName)) {
				groceryShelfMap.remove(groceryName);
				System.out.println(groceryName + " has been removed from grocery management system!");
			}		
		}
	}

	@Override public String toString() { for(Map.Entry<Groceries,String>
	groceryMap : groceryShelfMap.entrySet()) {
		System.out.println(groceryMap.getKey() + " on " + groceryMap.getValue()); }
	return "End of List!"; }

}
