/**
 * Represents a building and its attributes
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
 */
public class Buildings {

	private String name;
	private String intro;
	private String[] items;
	private boolean completed;
	private String winningText;
	private String losingText;
	private String winTrigger;
  private String[] loseTrigger;

	/**
	 * constructor for buildings, includes win/lose text
	 *
	 * @param intro       String introduction to building, including encounter
	 * @param items       String[] list of items in building
	 * @param winningText String text describing encounter success
	 * @param losingText  String describing encounter failure
	 * @param winTrigger  String ability required to win
	 * @param loseTrigger String ability required to lose
	 */
	public Buildings(String name, String intro, String[] items, String winningText, String losingText, String winTrigger, String[] loseTrigger) {
		this.completed = false;
		this.name = name;
		this.intro = intro;
		this.items = items;
		this.winningText = winningText;
		this.losingText = losingText;
		this.winTrigger = winTrigger;
    this.loseTrigger = loseTrigger;
	}

	/**
	 * constructor for buildings, without win/lose text
	 * 
	 * @param intro String introduction to building, including encounter
	 * @param items String[] list of items in building
	 */
	public Buildings(String name, String intro, String[] items) {
		this.completed = false;
		this.name = name;
		this.intro = intro;
		this.items = items;
	}

	/**
	 * getter for building name
	 * 
	 * @return building name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter for intro text
	 * 
	 * @return intro text
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * getter for array of items
	 * 
	 * @return items array
	 */
	public String[] getItems() {
		return items;
	}

	/**
	 * getter for winTrigger
	 * 
	 * @return winTrigger String
	 */
	public String getWinTrigger() {
		return winTrigger;
	}

	/**
	 * getter for loseTrigger
	 * 
	 * @return loseTrigger String
	 */
	public String[] getLoseTrigger() {
		return loseTrigger;
	}

	/**
	 * returns true if the building objective has been completed basically a getter
	 * for completed
	 * 
	 * @return true if
	 */
	public boolean hasCompleted() {
		return completed;
	}

	/**
	 * sets completed to true called when player completes a building
	 */
	public void complete() {
		completed = true;
	}

	/**
	 * getter for winning text
	 * 
	 * @return winning text
	 */
	public String getWinningText() {
		return winningText;
	}

	/**
	 * getter for losing text
	 * 
	 * @return losing text
	 */
	public String getLosingText() {
		return losingText;
	}

	/**
	 * removes an item from the items in the building. determines the index of the
	 * item to remove, then creates a new list by iterating through every item in
	 * the original list and skipping that index. this is a highly inefficient
	 * method, but it works.
	 * 
	 * @param item String name of item
	 */
	public void removeItem(String item) {
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(item)) {
				index = i;
				break;
			}
		}
		String[] replacement = new String[items.length - 1];
		for (int i = 0, k = 0; i < items.length; i++) {
			if (i == index) {
				continue;
			}
			replacement[k++] = items[i]; 
		}
    items = replacement;
		
	}

	/**
	 * creates a string sentence of the items in a building
	 * 
	 * @param items String list of items
	 * @return String sentence listing the items
	 */
	public static String toStringItems(String[] items) {
		String x = "There is ";
		if (items.length == 0) { // nothing
			x = x + "nothing";
		} else if (items.length == 1) { // one item
			x = x + "a " + items[0];
		} else if (items.length == 2){ //two items
      x = x + "a " + items[0];
      x = x + " and a " + items[1];
    } else { // three items
      for (int i = 0; i < (items.length - 1); ++i) {
				x = x + "a " + items[i] + ", ";
			}
			if (items.length != 1) {
				x = x + "and a " + items[items.length-1];
			}
		}
		x = x + " in the building.";
		return x;
	}

	/**
	 * returns true if an item is in the building
	 * 
	 * @param item String name of item
	 * @return true if item is in building
	 */
	public boolean contains(String item) {
		boolean result = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(item)) {
				result = true; 
			}
		}
		return result;
	}
}