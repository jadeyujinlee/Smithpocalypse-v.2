import java.util.ArrayList;

/**
 * Represents the player's inventory
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
 */
class Inventory {
	ArrayList<String> inventory;

	/**
	 * constructor for inventory
	 */
	public Inventory() {
		inventory = new ArrayList<String>();
	}

	/**
	 * prints inventory to console
	 */
	public void printI() {
		if (inventory.size() == 0) {
			System.out.println("Your inventory is empty.");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				System.out.println(inventory.get(i));
			}
		}
	}

  /**
	 * prints the contents of the various flyers and leaflets
	 * 
	 * @param flyer String the object to read
	 */
	public void read(String flyer) {
		if (flyer.equals("flyer")) {
			System.out.println(
					"ATTENTION INHABITANTS OF NORTHAMPTON \nEVACUATE THE AREA IMMEDIATELY \nESCAPE TO SMITH COLLEGE ATHLETIC FIELDS ACROSS PARADISE POND IF POSSIBLE \nOTHERWISE, MOVE TO THE NEAREST SAFEHOUSE: \nMcCONNELL HALL \nIF YOU SEE OTHER PEOPLE, DO NOT MAKE YOUR PRESENCE KNOWN. \nSOME PEOPLE MAY BE UNDER THE INFLUENCE OF AN UNKNOWN PATHOGEN \nTHAT CAUSES EXTREME HUNGER, RESISTANCE TO PAIN, AND LOSS OF INTELLIGENCE.");
		} else if (flyer.equals("leaflet")) {
			System.out.println(
					"ATTENTION INHABITANTS OF NORTHAMPTON \nEVACUATE THE AREA IMMEDIATELY \nESCAPE TO SMITH COLLEGE ATHLETIC FIELDS ACROSS PARADISE POND IF POSSIBLE \nOTHERWISE, MOVE TO THE NEAREST SAFEHOUSE: \nFORD HALL \nIF YOU SEE OTHER PEOPLE, DO NOT MAKE YOUR PRESENCE KNOWN. \nSOME PEOPLE MAY BE UNDER THE INFLUENCE OF AN UNKNOWN PATHOGEN \nTHAT CAUSES EXTREME HUNGER, RESISTANCE TO PAIN, AND LOSS OF INTELLIGENCE.");
		} else if (flyer.equals("poster")) {
			System.out.println(
					"ATTENTION INHABITANTS OF NORTHAMPTON \nEVACUATE THE AREA IMMEDIATELY \nESCAPE TO SMITH COLLEGE ATHLETIC FIELDS ACROSS PARADISE POND IF POSSIBLE \nOTHERWISE, MOVE TO THE NEAREST SAFEHOUSE: \nHILLYER ART LIBRARY \nTYLER HOUSE \nIF YOU SEE OTHER PEOPLE, DO NOT MAKE YOUR PRESENCE KNOWN. \nSOME PEOPLE MAY BE UNDER THE INFLUENCE OF AN UNKNOWN PATHOGEN \nTHAT CAUSES EXTREME HUNGER, RESISTANCE TO PAIN, AND LOSS OF INTELLIGENCE.");
		} else {
			System.out.println("You cannot read that, no matter how hard you try.");
		}
	}

	/**
	 * adds item to inventory
	 * 
	 * @param item String the item to add
	 */
	public void addI(String item) {
		inventory.add(item);
	}

	/**
	 * checks if item is in inventory
	 * 
	 * @param item String the item to check
	 * @return true if item is in inventory
	 */
	public boolean contains(String item) {
		if (inventory.contains(item)) {
			return true;
		} else {
			return false;
		}
	}
}