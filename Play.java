import java.util.Scanner;
import java.io.*;

/**
 * Runs the game. After constructing the map, it runs the game in a while loop.
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
 */
class Play {
	Node currentLocation;
	Buildings currentBuilding;
	Abilities abilities = new Abilities();
	Inventory inventory = new Inventory();
	Locations locations = new Locations();
	Responses responses = new Responses();
	boolean win = false;
  boolean completeFord = false;
	boolean completeMcconnell = false;

	/**
	 * constructor for class Play, which runs the majority of the game
	 *
	 * @param currentLocation
	 * @param currentBuilding
	 * @param abilities
	 * @param inventory
	 * @param locations
	 */
	public Play(Scanner sc) {
		this.currentLocation = locations.greenStreet;
		this.currentBuilding = currentBuilding;
		this.abilities = abilities;
		this.inventory = inventory;
		this.locations = locations;

		intro();
		while (win == false) { // runs each turn
			System.out.println("\n");
			Parse(sc); // takes user input
      
			if (currentBuilding != null){ // if player is in a building
        while((currentBuilding != null) && (!currentBuilding.hasCompleted())) {
          if(abilities.abilities.contains(currentBuilding.getWinTrigger())){ // if win trigger is met
            currentBuilding.complete(); //set building to complete
            System.out.println(currentBuilding.getWinningText());
						switch (currentBuilding.getName()){ // if player has completed a miniboss
              case "fordBuilding":
                completeFord = true;
                break;
              case "mcconnellBuilding":
                completeMcconnell = true;
                break;
            }
          }
          else if (!currentBuilding.getName().equals("boatHouseBuilding") && !currentBuilding.getName().equals("tylerBuilding") && !currentBuilding.getName().equals("hillyerBuilding") && !currentBuilding.getName().equals("botanicalGardenBuilding") && !currentBuilding.getName().equals("campusCenterBuilding") && !currentBuilding.getName().equals("neilsonBuilding") && !currentBuilding.getName().equals("chapinBuilding")){ // checks to make sure we're not in an area that has no win/lose encounters
            for (String x : currentBuilding.getLoseTrigger()){// loops through all possible lose triggers in that building
              if (x.equals(abilities.getLast())){// if the last ability you gained is a lose trigger
                System.out.println(currentBuilding.getLosingText());// you lose the whole game
                System.exit(0);
              }
            }
          }
					Parse(sc); // takes user input while inside building
        }
			}
		}
	}
	
  /**
	 * prints the intro text of the very beginning of the game 
	*/
  public void intro() {
		System.out.println(
		"Oh god, is that the time? You snoozed perhaps one hour too many, and now it seems like the sun is setting outside your window. Groggily you roll out of bed, dehyrdrated and ravenous. As you approach your dresser to put on some clothes, the smell of smoke permeates from your cracked window directly into your nose. Remembering that Hubbard's burn time is approximately 15 minutes, you hurry and begin to pack your bag. As you cross the room, you happen to turn and see outside. Everything is on fire. You quickly run down the stairs and out into the street. Which direction will you go?");
	}

	/**
	 * uses a Scanner to read the user's input and execute the corresponding method
	 * 
	 * @param sc Scanner
	 */
	public void Parse(Scanner sc) {
		String word = sc.nextLine();
		System.out.println("\n");
		word.toLowerCase();
		String[] response = word.split(" ");
		if (response.length == 0) { // if user types nothing
			String[] replace = { "null" };
			response = replace;
		}
		if (response.length == 1) { // if user types only one word
			String[] replace = { response[0], "null" };
			response = replace;
		}

		switch (response[0]) { // determines action to take based on first word
			case "walk":
			case "go": // travel to adjacent node
				walk(response[1]);
				System.out.println(currentLocation.getArea().getIntroText());
				break;
			case "inventory":
			case "items":
			case "check":
				inventory.printI();
        if (abilities.abilities.contains("flaregun")){// this is a special item only used in final boss fight
          System.out.println("flare gun");
        }
				break;
			case "bike":
			case "ride":
			case "travel": // travel to any node
				if (currentBuilding != null) {
					System.out.println("You need to leave the building first.");
				} else {
					travel(response[1]);
				}
				break;
			case "read": // for posters, flyers, etc.
				inventory.read(response[1]);
				break;
			case "take":
			case "grab":
				takeItem(response);
				break;
      case "run":
			case "exit":
			case "leave": 
        if (currentBuilding != null){
          switch(currentBuilding.getName()){
            case "botanicalGardenBuilding": // this is because these specific buildings do not have win or lose situations.
            case "campusCenterBuilding":
            case "chapinBuilding":
            case "tylerBuilding":
            case "boathouseBuilding":
            case "hillyerBuilding": 
              currentBuilding.complete();
              break;
          }
        }
				leaveBuilding();
				break;
			case "enter":
				enter(response[1]);
				break;
			case "save": // to save, calls saveFile() 
				System.out.println("Saving…");
				try { 
					saveFile();
				} catch (IOException e) {
					System.out.println("Error: could not save");
				}
				System.out.println("Saved!");
				break;
			case "load": // to load saved progress 
				loadSave();
				break;
			default:
				switch (response[1]) { // for words that may be inputted with spaces 
					case "first":
						response[1] = "firstaid";
						break;
					case "life":
						response[1] = "life vest";
						break;
					case "one":
						response[1] = "onecard";
						break;
					case "holy":
						response[1] = "holyhandgrenade";
						break;
				}
				switch (response[1]) {
					case "shovel":
					case "firstaid":
					case "hydroflask":
					case "extinguisher":
					case "lifevest":
					case "flashlight":
					case "onecard":
					case "saw":
					case "chair":
					case "food":
					case "candy":
					case "poster":
					case "water":
					case "flyer":
					case "leaflet":
					case "holyhandgrenade":
					case "music":
          case "book":
            if(inventory.contains(response[1])){ // an item needs to be in an inventory in order to use as an ability 
              boolean isValid = responses.respond(response[0], response[1]);
              if (isValid){
							abilities.gain(response[1]);
						  }
            }
            else{
              System.out.println("That's not in your inventory.");
            }
						break;
					default:
						System.out.println("Unknown prompt. Try spelling again or check your inventory!");
        
				}
		}
	}

	/**
	 * quicktravel via bike, moves player to defined node
	 * 
	 * @param place String the place to move, as defined by user
	 */
	public void travel(String place) {
		Node moveTo = currentLocation;
		switch (place) {
			case "elm":
				System.out.println("You can't travel there.");// these are the nodes that don't point to anything, so we keep them from quick travelling there
				break;
			case "west":
				System.out.println("You can't travel there.");
				break;
			case "lake":
			case "pond":
			case "paradise":
        if (completeFord && completeMcconnell && inventory.contains("oar")){
          lakeFight();
        }
				System.out.println("You can't travel there.");
				break;
			case "burton":
				moveTo = locations.burtonLawn; 
				break;
			case "chapin":
				moveTo = locations.chapinLawn;
				break;
			case "upper":
			case "uppershore":
				moveTo = locations.upperShore;
				break;
			case "middle":
			case "middleshore":
				moveTo = locations.middleShore;
				break;
			case "lower":
			case "lowershore":
				moveTo = locations.lowerShore;
				break;
			case "president's":
			case "presidents":
			case "president":
				moveTo = locations.presHouse;
				break;
			case "seelye":
				moveTo = locations.seelyeLawn;
				break;
			case "college":
			case "collegehall":
				moveTo = locations.collegeHall;
				break;
			case "green":
			case "greenst":
			case "greenstreet":
				moveTo = locations.greenStreet;
				break;
			case "ford":
				moveTo = locations.ford;
				break;
			default:
				System.out.println("Invalid location");
		}
		
		if (inventory.contains("bike")) { // you can only quick travel if you've obtained the bike for your inventory
			currentLocation = moveTo;
			System.out.println("\n"+moveTo.getArea().getIntroText());
		} else {
			System.out.println(
					"You need a bike to quickly travel to different locations. If you want to walk somewhere, say \"walk\" or \"go\"");
		}
	}

	/**
	 * player walks to adjacent area of campus
	 * 
	 * @param direction String the NESW direction to walk
	 */
	public void walk(String direction) {
    if (currentBuilding != null){
      System.out.println("You need to leave the building before you can go anywhere.");
    }
    else{
      switch (direction) {
        case "north":
        case "n":
          if (!locations.isNullNode(currentLocation.getNorth())) {
            currentLocation = currentLocation.getNorth();
          }
          else{
            System.out.println(currentLocation.getNorth().getArea().getIntroText()+"\n");
          }
          break;
        case "e":
        case "east":
          if (!locations.isNullNode(currentLocation.getEast())) {
            currentLocation = currentLocation.getEast();
          }
          else{
            System.out.println(currentLocation.getEast().getArea().getIntroText()+"\n");
          }
          break;
        case "s":
        case "south":
          if (!locations.isNullNode(currentLocation.getSouth())) {
            currentLocation = currentLocation.getSouth();
          }
          else{
            System.out.println(currentLocation.getSouth().getArea().getIntroText()+"\n");
          }
          break;
        case "w":
        case "west":
          if (!locations.isNullNode(currentLocation.getWest())) {
            currentLocation = currentLocation.getWest();
          }
          else{
            System.out.println(currentLocation.getWest().getArea().getIntroText()+"\n");
          }
          break;
        default:
          System.out.println("Invalid direction.");
      }
    }
	}

	/**
	 * player leaves building 
	 */
	public void leaveBuilding() {
		if (currentBuilding != null) {
			currentBuilding = null;
      abilities.abilities.clear();
      abilities.gain("null");
			System.out.println("You exit the building.\n");
      System.out.println(currentLocation.getArea().getIntroText());
		}
	}

	/**
	 * player enters building
	 *
	 * @param building String the building to enter
	 */
	public void enter(String building) {
		Buildings moveTo = locations.isInArea(currentLocation, building);
		if (moveTo == null){
			System.out.println("That is not a valid building.");
		}
		else {
      if(moveTo.hasCompleted()) {
        System.out.println("You have already completed this building, and can no longer enter it.");
        String[] items = moveTo.getItems();
        if (items.length != 0){
          System.out.println("You see something in the rubble. It looks like you forgot something when you were here earlier.");
          for (String x : items){
            inventory.addI(x);
            System.out.println(x + " has been added to your inventory.");
          }
        }
		  } else if (currentBuilding == null) {
          if (moveTo != null) {
            currentBuilding = moveTo;
            System.out.println(Buildings.toStringItems(moveTo.getItems()));
            System.out.println(currentBuilding.getIntro());
          } else {
            System.out.println("That is not a valid building.");
          }
      } else {
        System.out.println("You are already in a building. You have to leave this one first.");
      }
		}
	}

	/**
	 * player takes item from building and it is placed into inventory
	 * 
	 * @param response String[] the user's input
	 */
	public void takeItem(String[] response) {
		String item = response[1];
		if (currentBuilding.contains(item)) {
			inventory.addI(item);
			currentBuilding.removeItem(item);
			System.out.println("You take the " + item + ".\n");
		} else {
			System.out.println("That item doesn't exist here.\n");
		}
	}


	/**
	* saves the current gamestate
	*/
	public void saveFile() throws IOException {

		String buildingName = "";
		String nodeName = currentLocation.getName();
		if (currentBuilding != null) {
			buildingName = currentBuilding.getName();
		} else {
			buildingName = "null";
		}

		// building item lists
		String[][] itemsList = { locations.seelyeBuilding.getItems(), locations.burtonBuilding.getItems(),
				locations.neilsonBuilding.getItems(), locations.mcconnellBuilding.getItems(),
				locations.chapinBuilding.getItems(), locations.collegeHallBuilding.getItems(),
				locations.tylerBuilding.getItems(), locations.alumnaeGymBuilding.getItems(),
				locations.hillyerBuilding.getItems(), locations.fordBuilding.getItems(),
				locations.schachtCenterBuilding.getItems(), locations.sageBuilding.getItems(),
				locations.boathouseBuilding.getItems(), locations.campusCenterBuilding.getItems(),
				locations.botanicalGardenBuilding.getItems() };

		// which buildings are completed
		boolean[] completedB = { locations.seelyeBuilding.hasCompleted(), locations.burtonBuilding.hasCompleted(),
				locations.neilsonBuilding.hasCompleted(), locations.mcconnellBuilding.hasCompleted(),
				locations.chapinBuilding.hasCompleted(), locations.collegeHallBuilding.hasCompleted(),
				locations.tylerBuilding.hasCompleted(), locations.alumnaeGymBuilding.hasCompleted(),
				locations.hillyerBuilding.hasCompleted(), locations.fordBuilding.hasCompleted(),
				locations.schachtCenterBuilding.hasCompleted(), locations.sageBuilding.hasCompleted(),
				locations.boathouseBuilding.hasCompleted(), locations.campusCenterBuilding.hasCompleted(),
				locations.botanicalGardenBuilding.hasCompleted() };

		if (inventory.inventory.size() == 0) {
			inventory.addI("null");
		}
		if (abilities.abilities.size() == 0) {
			abilities.gain("null");
		}

		Save.writeToFile(inventory.inventory, nodeName, buildingName, itemsList, completedB, abilities.abilities,completeFord,completeMcconnell);
	}

	/**
	 * calls the readFromFile method from Save to load the previous save data
   *
   * uses a 2D array to receive info from save file, then gives it to the proper methods/classes
	 */
	public void loadSave() {
		String[][] bigArray = new String[5][20]; // to quote Skye: "it's an array that's big."
		try { // no but actually it's a double array where each line is divided into a String[]
			bigArray = Save.readFromFile();
		} catch (IOException e) {
			System.out.println("IO Exception.");
		}
		String[] toInventory = bigArray[0];
		inventory.inventory.clear();

		for (String i : toInventory) {
			if (!i.equals("null")) {
				if (!inventory.contains(i)) {
					inventory.addI(i);
				}
			}
		}
    
    if (bigArray[5][0].equals("true")){
      this.completeFord = true;
    }
    if (bigArray[5][1].equals("true")){
      this.completeMcconnell = true;
    }
    
    setComplete(bigArray[3]);
    
		readLocations(bigArray[1][0], bigArray[1][1]);
		setItems(bigArray[0]);
		System.out.println("Loaded!");
	}

  /**
  * makes sure to set completed buildings as completed
  * @param String[] list  
  */
  public void setComplete(String[] list){
    if (list[0].equals("true")){
      locations.seelyeBuilding.complete();
    }
    if (list[1].equals("true")){
      locations.burtonBuilding.complete();
    }
    if (list[2].equals("true")){
      locations.neilsonBuilding.complete();
    }
    if (list[3].equals("true")){
      locations.mcconnellBuilding.complete();
    }
    if (list[4].equals("true")){
      locations.chapinBuilding.complete();
    }
    if (list[5].equals("true")){
      locations.collegeHallBuilding.complete();
    }
    if (list[6].equals("true")){
      locations.tylerBuilding.complete();
    }
    if (list[7].equals("true")){
      locations.alumnaeGymBuilding.complete();
    }
    if (list[8].equals("true")){
      locations.hillyerBuilding.complete();
    }
    if (list[9].equals("true")){
      locations.fordBuilding.complete();
    }
    if (list[10].equals("true")){
      locations.schachtCenterBuilding.complete();
    }
    if (list[11].equals("true")){
      locations.sageBuilding.complete();
    }
    if (list[12].equals("true")){
      locations.boathouseBuilding.complete();
    }
    if (list[13].equals("true")){
      locations.campusCenterBuilding.complete();
    }
    if (list[14].equals("true")){
      locations.botanicalGardenBuilding.complete();
    }
  }

	/** 
  * if the inventory has an item, then remove that item from the building it's from
  *
  * helper function for loadSave
  *
  * @param items String[] the items in the inventory
  */
	public void setItems(String[] items) {
    Buildings[] allBuildings = locations.getAllBuildings();
    for (Buildings b: allBuildings){
      for (String i : items){
        if (b.contains(i)){
          b.removeItem(i);
        }
      }
    }
	}

	/**
	 * helper function for loadSave. parses string names of locations from the save
	 * file and sets the player's location to the associated node/building.
	 *
	 * @param nodeName     String
	 * @param buildingName String
	 */
	public void readLocations(String nodeName, String buildingName) {
		switch (nodeName) {
			case "burtonLawn":
				currentLocation = locations.burtonLawn;
				break;
			case "chapinLawn":
				currentLocation = locations.chapinLawn;
				break;
			case "upperShore":
				currentLocation = locations.upperShore;
				break;
			case "middleShore":
				currentLocation = locations.middleShore;
				break;
			case "lowerShore":
				currentLocation = locations.lowerShore;
				break;
			case "presHouse":
				currentLocation = locations.presHouse;
				break;
			case "seelyeLawn":
				currentLocation = locations.seelyeLawn;
				break;
			case "collegeHall":
				currentLocation = locations.collegeHall;
				break;
			case "greenStreet":
				currentLocation = locations.greenStreet;
				break;
			case "ford":
				currentLocation = locations.ford;
				break;
			default:
				System.out.println("Invalid location in save file");
				currentLocation = null;
		}
		switch (buildingName) {
			case "seelyeBuilding":
				currentBuilding = locations.seelyeBuilding;
				break;
			case "burtonBuilding":
				currentBuilding = locations.burtonBuilding;
				break;
			case "neilsonBuilding":
				currentBuilding = locations.neilsonBuilding;
				break;
			case "mcconnellBuilding":
				currentBuilding = locations.mcconnellBuilding;
				break;
			case "chapinBuilding":
				currentBuilding = locations.chapinBuilding;
				break;
			case "collegeHallBuilding":
				currentBuilding = locations.collegeHallBuilding;
				break;
			case "tylerBuilding":
				currentBuilding = locations.tylerBuilding;
				break;
			case "alumnaeGymBuilding":
				currentBuilding = locations.alumnaeGymBuilding;
				break;
			case "hillyerBuilding":
				currentBuilding = locations.hillyerBuilding;
				break;
			case "fordBuilding":
				currentBuilding = locations.fordBuilding;
				break;
			case "schachtCenterBuilding":
				currentBuilding = locations.schachtCenterBuilding;
				break;
			case "sageBuilding":
				currentBuilding = locations.sageBuilding;
				break;
			case "boathouseBuilding":
				currentBuilding = locations.boathouseBuilding;
				break;
			case "campusCenterBuilding":
				currentBuilding = locations.campusCenterBuilding;
				break;
			case "botanicalGardenBuilding":
				currentBuilding = locations.botanicalGardenBuilding;
				break;
			default:
				currentBuilding = null;
		}
	}

  /**
  * runs the final boss endgame. Because the last few events are heavily scripted and modifying the rest of the code to work with this would be extraordinarily difficult, we chose to hard-code the fight here. 
  */
	public void lakeFight(){
		System.out.println("You have exhausted every possibility, every remnant of what's left of your school. At least we hope you did, because you really should try and get to safety. Luck can only get you so far when in the apocalypse on your own. There has to be a reason you got this flare gun and this inflatable kiddie pool raft (which is still in the box). \n\nBefore you know it, you're at the lake. An idea about how to escape sprouts into your mind. The flyers said that there were military encampments on the other side of Paradise Pond, however, they're going to shoot first, ask questions later. How can you alert their attention?"); 
    
    Scanner lakescan = new Scanner(System.in); 

    // in this section, the user needs to inflate the boat.
    
    boolean isInflated = false;
    while (!isInflated){
      String getBoat = lakescan.nextLine(); 
      String [] response = getBoat.split(" ");
      switch (response[0]) {
        case "paddle":
        case "row":
          System.out.println("It's a bit hard to paddle across the lake when, you know, your only means of transport is not inflated.");
          break;
        case "inflate":
          if (response[1].equals("boat") || response[1].equals("raft") ||response[1].equals("pool") || response[1].equals("kiddie")){
            System.out.println("You quickly inflate the boat as fast as possible, which, with adrenaline-powered lungs ends up being pretty fast. You then put it out on the water, where it lands with a splash. What's next?");
            isInflated = true;
          }
          break;
        case "fire":
          System.out.println("You were about to fire the flare gun, but intelligently realized that the fog from this distance is blocking the light...and is so thick and toxic that it also blocks the sound.");
          break;
        case "use":
          if (response[1].equals("oar")){
            System.out.println("It's a bit hard to paddle across the lake when, you know, your only means of transport is not inflated.");
          }
          else if (response[1].equals("flare")){
            System.out.println("You were about to fire the flare gun, but intelligently realized that the fog is blocking the light from the flare. You should save your ammunition until you get closer to someone who can see it.");
          }
          else if (response[1].equals("boat")){
            System.out.println("You can't use the vessel because it's not inflated.");
          }
          else {
            System.out.println("You can't use that now.");
            }
          break;
        case "inventory":
  			case "items":
  			case "check":
  				inventory.printI();
          if (abilities.abilities.contains("flaregun")){
            System.out.println("flare gun");
          }
  				break;
        default: System.out.println("You can't do that right now. You're too busy trying to escape.");
      }
      System.out.println("\n");
    }

    // in this section, the user needs to get in the boat.
    
    boolean inBoat = false;
    while (!inBoat){
      String getInBoat = lakescan.nextLine(); 
      String [] secondResponse = getInBoat.split(" ");
      switch (secondResponse[0]) {
        case "paddle":
        case "row":
          System.out.println("So you've managed to throw the boat onto the water, however, it's a bit hard to paddle across the lake when, you know, you aren't actually in the boat.");
          break;
        case "inflate":
          if (secondResponse[1].equals("boat") || secondResponse[1].equals("raft") ||secondResponse[1].equals("pool") || secondResponse[1].equals("kiddie")){
            System.out.println("You already did that.");
          }
          break;
        case "fire":
          System.out.println("You were about to fire the flare gun, but intelligently realized that the fog from this distance is blocking the light...and is so thick and toxic that it also blocks the sound.");
          break;
        case "use":
          if (secondResponse[1].equals("oar")){
            System.out.println("So you've managed to throw the boat onto the water, however, it's a bit hard to paddle across the lake when, you know, you aren't actually in the boat.");
          }
          else if (secondResponse[1].equals("flare")){
            System.out.println("You were about to fire the flare gun, but intelligently realized that the fog is blocking the light from the flare. You should save your ammunition until you get closer to someone who can see it...or until you have no other option.");
          }
          else {
            System.out.println("You can't use that now.");
            }
          break;
        case "enter":
        case "get":
        case "board":
          System.out.println("You carefully lower yourself into the boat, trying to avoid the foul-smelling water.");
          inBoat = true;
          break;
        case "inventory":
  			case "items":
  			case "check":
  				inventory.printI();
          if (abilities.abilities.contains("flaregun")){
            System.out.println("flare gun");
          }
  				break;
        default: System.out.println("Unknown prompt. You can't do that right now.");
      }
      System.out.println("\n");
    }

     // in this section, the user needs to row the boat.
    
    boolean isRowing = false;
    while (!isRowing){
      String startRowing = lakescan.nextLine(); 
      String [] thirdResponse = startRowing.split(" ");
      switch (thirdResponse[0]) {
        case "paddle":
        case "row":
          if (thirdResponse[1].equals("boat") || thirdResponse[1].equals("raft") ||thirdResponse[1].equals("pool") || thirdResponse[1].equals("kiddie")) {
            System.out.println("You touch the oar down into the water and begin to propel yourself forward.");
            isRowing = true;
          }
          break;
        case "inflate":
            System.out.println("You already did that.");
          break;
        case "fire":
          System.out.println("You were about to fire the flare gun, but intelligently realized that the fog is blocking the light from the flare. You should save your ammunition until you get closer to someone who can see it...or until you have no other option.");
          break;
        case "use":
          if (thirdResponse[1].equals("oar")){
            System.out.println("You touch your oar down into the water and begin to propel yourself forward. You make it past the island in the middle of the lake, and just when you think you're close enough to send a signal...");
            isRowing = true; 
          }
          else if (thirdResponse[1].equals("flare")){
            System.out.println("You were about to fire the flare gun, but intelligently realized that the fog is blocking the light from the flare. You should save your ammunition until you get closer to someone who can see it...or until you have no other option.");
          }
          else {
            System.out.println("You can't use that now.");
            }
          break;
        case "inventory":
  			case "items":
  			case "check":
  				inventory.printI();
          if (abilities.abilities.contains("flaregun")){
            System.out.println("flare gun");
          }
  				break;
        default: System.out.println("Unknown prompt. You can't do that right now.");
      }
      System.out.println("\n");
    }
    
    //the second half of the lake fight begins now. 
    System.out.println("OH GOD. \n\nNO WAY. \n\nIS THAT... PRESIDENT KATHLEEN MCCARTNEY? WHY. WHY. WHY. WHY. WHY. \n\nZombie K-Mac emerges from the water very slowly, back turned to you. Then, she snaps her head back and begins to swim towards you at an inhuman pace. \n\nYou paddle furiously, but you're not fast enough. She grabs your kiddie pool liferaft and begins dragging you back to shore.");

    // in this section, the user needs to get free of Zombie President Kathleen McCartney.
    boolean isFreeFromGrasp = false;
    while (!isFreeFromGrasp){
      String escapeKMAC = lakescan.nextLine(); 
      String [] fourthResponse = escapeKMAC.split(" ");
      switch (fourthResponse[0]) {
        case "paddle":
        case "row":
          System.out.println("You can't outpaddle the invincible boss-zombie. Hurry up, she's almost got you back at the middle of the lake! What, are you running out of options or something?");
          break;
        case "inflate":
            System.out.println("You already did that!!! Now is not the time!!!");
          break;
        case "fire":
        case "shoot":
          System.out.println("You're running out of time and options. What is left? You look down at your flare gun and wonder if the military camp on the athletic fields would be able to see it as she's pulling you further away. \n\nYou no longer have a choice. You dive for the gun and cover your other ear, \n\nBANG! \n\nTo your surprise, the flare makes Zombie KMac distracted for just a moment, her head following the direction of the light. It gives you just enough time to start rowing again. Maybe the camp didn't see it, but they sure heard it.");
          isFreeFromGrasp = true;
          break;
        case "use":
          if (fourthResponse[1].equals("oar")){
            System.out.println("You can't outpaddle the invincible boss-zombie. Hurry up, She's almost got you back at the middle of the lake!");
          }
          else if (fourthResponse[1].equals("flare")||fourthResponse[1].equals("flaregun")){
            System.out.println("You're running out of time and options. What is left? You look down at your flare gun and wonder if the military camp on the athletic fields would be able to see it as she's pulling you further away. \n\nYou no longer have a choice. You dive for the gun and cover your other ear, \n\nBANG! \n\nTo your surprise, the flare makes Zombie KMac distracted for just a moment, her head following the direction of the light. It gives you just enough time to start rowing again. Maybe the camp didn't see it, but they sure heard it, since the fog is thinner here.");
            isFreeFromGrasp = true;
          }
          else {
            System.out.println("You can't use that now.");
            }
          break;
        case "inventory":
  			case "items":
  			case "check":
  				inventory.printI();
          if (abilities.abilities.contains("flaregun")){
            System.out.println("flare gun");
          }
  				break;
        default: System.out.println("Unknown prompt. You can't do that right now.");
      }
      System.out.println("\n");
    }
    lakescan.close();

    System.out.println("The desperation makes you faster. Sweat runs down your brow as the fog begins to thin, and because you're rowing backwards this time you can see her coming after you. Just as her hand nearly grabs your vessel again, she gets snagged on the large branch in the shallow end of the lake.");
    System.out.println("\nThe ringing in your ears from the flare gun just makes the pounding of your heart louder. You realize the lake is getting shallower and shallower, but before you can panic, you lurch foward, having hit land. You leap as far as you can and both feet land on the ground.");
    System.out.println("\nYou can't even be bothered to catch your breath before starting to sprint towards the athletic field, waving your arms around while calling for help. It isn't long before the military finds you and takes you to safety.");
    System.out.println("\nCongratulations. You have managed to single-handedly survive the Smith-pocalypse.");

    System.out.println("\n\nCreated by\nJade Lee\nAnna Wilson\nSkye Worster\n\nCSC212\nVersion Fall 2021");
    System.exit(0);
	}
}