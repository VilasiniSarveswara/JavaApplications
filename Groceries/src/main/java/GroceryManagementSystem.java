import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class GroceryManagementSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<Groceries,String> groceryMap = new HashMap<Groceries, String>();
		int choice;
		System.out.println("Welcome to your Grocery Manangement System!");
		System.out.println("--------------------------------------------");
		do {
			
			System.out.println("\nPlease choose what you would like to do? \n");
			System.out.println("1.Add a grocery to the management system \n"
					+ "2.Check the availability of a grocery item \n"
					+ "3.See the list of all groceries and quantities \n"
					+ "4.Remove an item from the management system \n"
					+ "5.Do nothing.Exit!");
			choice = Integer.parseInt(input.nextLine());
			if(choice == 1) {

				System.out.println("How many items do you wish to add?");
				int counter = Integer.parseInt(input.nextLine());

				for(int i = 0; i < counter ; i++ ) {
					System.out.println("Please enter the name of the grocery: ");
					String nameOfGrocery = input.nextLine();
					System.out.println("Please enter the quantity of the grocery: ");
					String groceryQuantity = input.nextLine();
					Groceries grocery = new Groceries(nameOfGrocery, groceryQuantity);
					System.out.println("Please specify where you would like to keep this in your pantry. ");
					String shelfName = input.nextLine();
					groceryMap.put(grocery, shelfName);	
				}	
				System.out.println("All the groceries have been added to you Grocery Management System \n");
			}
			Pantry pantryMap = new Pantry(groceryMap);		
			
			//Check the availability of a certain grocery.
			if(choice == 2) {
				System.out.println("Please enter the name of the grocery you would like to check: ");
				String groceryNameToCheck = input.nextLine();
				pantryMap.getAvailabiltyOfGrocery(groceryNameToCheck);
			}
			
			//Check the entire pantry
			if(choice == 3) {
				pantryMap.toString();
			}
			
			//Remove a grocery from the GMS
			if(choice == 4) {
				System.out.println("Please enter the grocery you'd like to remove: ");
				String groceryToRemove = input.nextLine();
				pantryMap.removeGroceryFromSystem(groceryToRemove);
			}
			
			if(choice == 5) {
				System.out.println("Good bye!Have a great day!");
			}
		} while( choice != 5);
		input.close();				
	}
}
