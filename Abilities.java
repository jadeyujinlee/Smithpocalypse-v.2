import java.util.ArrayList;

/** 
 *Stores the items that have been acquired and used 
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
*/
public class Abilities{
  ArrayList<String> abilities;

	/**
	* constructor for abilities HashMap
	* initializes all abilities as false
	*/
  public Abilities(){
    abilities = new ArrayList<String>();
		abilities.add("walking");
  }
  
  /**
  * turns the boolean of an ability to true (for when the player gains an ability)
  * @param ability the ability gained
  */
  public void gain(String ability){
    abilities.add(ability);
  }

	/**
  * @return true if biking unlocked
  */
	public boolean canBike(){
		return abilities.contains("biking");
	}

	/**
  * @return last string in list
  */
	public String getLast(){
		int index = abilities.size() - 1;
		if (index == 0){
			return "";
		}
		else{
			return abilities.get(index);
		}
	} 
}