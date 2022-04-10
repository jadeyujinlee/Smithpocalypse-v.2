/**
 * Class to represent one node of a graph (this will be one area on a map of
 * Smith College) with introduction sentences of type String and contained
 * buildings of type String[]. It has north, south, east, and west pointers to
 * different nodes that represent areas of the map.
 *
 * @author Anna Wilson
 * @version Fall 2021
 */
public class Node {
	/** the name of the node as a string */
  private String name;

	/** the buildings that the area represented by the node contains */
	private Area area;

	/** Link to the north node */
	private Node north;

	/** Link to the east node */
	private Node east;

	/** Link to the south node */
	private Node south;

	/** Link to the west node */
	private Node west;

	/**
	 * Constructor for Node. Takes Area (which has area/building data), pointers to neighbors, and its name as a string
	 * 
	 * @param area Area the area the node contains
	 * @param north link to the north node
	 * @param east Node link to the east node
	 * @param west Node link to the west node
	 * @param south Node link to the south node
	 * @param name Node String name of the node
	 */
	public Node(String name, Area area, Node north, Node east, Node south, Node west) {
		this.area = area;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
    this.name = name; 
	}

	/** @return the introduction at this node */
	public Area getArea() {
		return area;
	}

	/** @return the name of this node */
  public String getName(){
    return name;
  }

	/** @return reference to the north node */
	public Node getNorth() {
		return north;
	}

	/** @return reference to the east node */
	public Node getEast() {
		return east;
	}

	/** @return reference to the south node */
	public Node getSouth() {
		return south;
	}

	/** @return reference to the west node */
	public Node getWest() {
		return west;
	}

	/** @param area Area */
	public void setArea(Area area) {
		this.area = area;
	}

	/** sets the north pointer of the node to specified location */
	public void setNorth(Node pointer) {
		this.north = pointer;
	}

	/** sets the east pointer of the node to specified location */
	public void setEast(Node pointer) {
		this.east = pointer;
	}

	/** sets the south pointer of the node to specified location */
	public void setSouth(Node pointer) {
		this.south = pointer;
	}

	/** sets the west pointer of the node to specified location */
	public void setWest(Node pointer) {
		this.west = pointer;
	}
}