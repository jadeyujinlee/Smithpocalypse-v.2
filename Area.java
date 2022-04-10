/**
 * Represents an area of the map
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
*/
public class Area {

	// declaring variables
	private String introText;
	private Buildings[] buildings;

	/**
	 * Area constructor, holds intro text and array of buildings
	 * 
	 * @param introText String area description
	 * @param buildings Buildings[] array of buildings within the area
	 */
	public Area(String introText, Buildings[] buildings) {
		this.introText = introText;
		this.buildings = buildings;
	}

	/** 
	* getter for intro text 
	* 
	* @return introText
	*/
	public String getIntroText() {
		return introText; 
	}

	/** 
	* getter for buildings
	* 
	* @return buildings
	*/
	public Buildings[] getBuildings() {
		return buildings;
	}

	/*
	 * determines whether a given building is in the area
	 *
	 * @param b building to search for
	 * 
	 * @return true if building is in the area
	 */
	public boolean containsB(Buildings b) {
		boolean hasB = false;
		for (Buildings x : buildings) {
			if (x == b) {
				hasB = true;
			}
		}
		return hasB;
	}
}