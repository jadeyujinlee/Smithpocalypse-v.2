 /**
 * 
 * Class to represent large Locations on Smith Map using the
 * node structure of Node.java
 * 
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
 */
class Locations {

  // initialize nodes
	Node elm;
	Node lake;
	Node westStreet;
	Node chapinLawn;
	Node upperShore;
	Node middleShore;
	Node lowerShore;
	Node presHouse;
	Node burtonLawn;
	Node collegeHall;
	Node seelyeLawn;
	Node ford;
	Node greenStreet;

	// initialize buildings
	Buildings admissionsBuilding;
	Buildings seelyeBuilding;
	Buildings neilsonBuilding;
	Buildings burtonBuilding;
	Buildings chapinBuilding;
	Buildings campusCenterBuilding;
	Buildings boathouseBuilding;
	Buildings collegeHallBuilding;
	Buildings mcconnellBuilding;
	Buildings tylerBuilding;
	Buildings alumnaeGymBuilding;
	Buildings botanicalGardenBuilding;
	Buildings sageBuilding;
	Buildings hillyerBuilding;
	Buildings fordBuilding;
	Buildings schachtCenterBuilding;
  
	/**
	 * constructor for Locations. There are a lot of moving parts here:
	 *
	 * 1 - creates String[] of items in each building
	 * 2 - creates String[] of lose conditions for each building
   * 3 - initiates building objects
	 * 4 - creates Buildings[] that list the buildings in each area
	 * 5 - initiates each area object
   * 6 - initiates each node (and associating it with an Area and where it points)
	 */
	public Locations() {

		// 1 - creates String[] of items in each building
		//String[] admissionsItems = { "candy", "poster" }; 
		String[] chapinItems = { "poster", "food", "water" };
		String[] campusCenterItems = { "poster", "bike" };
		String[] schachtCenterItems = { "firstaid", "flyer" };
		String[] seelyeItems = { "hydroflask" }; 
		String[] neilsonItems = { "extinguisher" };
		String[] boathouseItems = { "lifevest", "flashlight", "leaflet"}; 
		String[] burtonItems = { "onecard" }; 
		String[] collegeHallItems = { "leaflet" };
		String[] mcconnellItems = { "saw" };
		String[] tylerItems = { "food", "candy" };
		String[] alumnaeGymItems = { "chair" };
		String[] fordItems = { "holyhandgrenade" };
		String[] hillyerItems = { "book" };
		String[] sageItems = { "music" };
		String[] botanicalGardenItems = { "shovel", "oar" };

		// 2 - creates String[] of lose conditions for each building
    // parameters: name, intro text, items, (winning text), (losing text)

		String[] collegeHallLose = {"holyhandgrenade", "saw"};
		String[] mcconnellLose = {"holyhandgrenade", "saw", "chair", "hydroflask", "shovel"};
    String[] fordLose = {};
    String[] schachtCenterLose = {};
    String[] burtonLose = {"holyhandgrenade", "book", "music", "saw", "shovel", "lifevest", "flashlight", "leaflet", "poster", "flyer", "chair", "food", "water"};
    String [] neilsonLose = {"hydroflask", "lifevest", "flashlight", "chair", "holyhandgrenade", "book", "music", "shovel", "food", "water", "candy", "firstaid"}; 
    String[] seelyeLose = {"candy", "flyer", "firstaid", "food", "book", "music", "poster", "leaflet", "lifevest", "flashlight"}; 
    String[] sageLose = {"candy", "firstaid", "food", "holyhandgrenade", "saw", "chair", "hydroflask", "shovel"};
    String[] alumnaeGymLose = {"food", "candy", "firstaid"};
    
    // 3 - initiates building objects
    // paramaters: name, intro text, items, (winning text), (losing text)
		this.seelyeBuilding = new Buildings("seelyeBuilding"," \n\nThe once-beautiful white and red brick building covered in soot and bullet holes. \nIt's almost heartbreaking how much the school used to fix up its edges constantly just for it to become... nothing.\nUpon entry, you begin calling out to see if anyone's there, running up to the third floor... that's when you see the zombie.\nGrotesque, an oozing mess of pus and blood and decomposing flesh. You accidentally knock over the Hydroflask that was on the ground and the zombie lunges.",seelyeItems,"With your heart pounding out of your chest, you swing at the zombie with all the strength you can muster. A deafening crack pierces the air and the monster falls down unceremoniously. You can barely hear anything over your own heartbeat, but you quickly turn on your heels and run towards the door without giving yourself a chance to think.","You're a valiant one, for sure. Now we know that when faced with distress, you are a fighter. A bit difficult when you have no weapons to fight against a supernatural, cannibalistic entity. You died.", "hydroflask", seelyeLose);
		this.neilsonBuilding = new Buildings("neilsonBuilding","\n\nThe Neilson Library. You used to detest coming here in the late hours of the night, and now, seeing it desolate and disappearing, you miss those nights. Out of the corner of your eye, you see an exposed wire dangerously close to a pile of papers. You decide to ignore it and continue to scrounge around, looking for anything– a working computer, water, anything! \nThen, a gust of wind rushes through the open windows and the pile of papers land right on the actively flaring wire.\n \nThe entire floor bursts into flames.\n\nIn a panic, you get away as far from the fire as possible.  The books are most definitely a lost cause, judging by how they're practically flinging themselves into the flames. \nYour back hits the bookshelf and you realize you've cornered yourself.",neilsonItems,"Smart, you spotted the fire extinguisher hooked onto the adjoining wall and lunged for it. \nYou've never used one of these before, but you rip out the key and begin to spray yourself a path to the exit.","Turns out, you have an extreme and paralyzing fear of fire. \nEspecially when you've managed to corner yourself by backing up into the elevator doors, the angry fire covering all exits. \nYou decided to run, but your clothes caught on fire and you inhaled too much smoke...\nThe darkness is encroaching your vision more and more...\nYou were unable to escape the Neilson library. How utterly ironic.", "extinguisher", neilsonLose);
		this.burtonBuilding = new Buildings("burtonBuilding", " \n\nIt's kind of falling apart. That's... probably okay, right?\nOh god, no no no no it is NOT okay!\nThe weight of your footsteps cracks the floor, and to your disbelief, the crack crawls up the wall and all the way into the roof.\nThe sound stops, and silence returns. \nYou spot a OneCard on the floor in the distance – do you need it? The ceiling is now literally falling on you. What is your next move?",burtonItems,"I guess your instincts decided you need a OneCard, how interesting!\nNevertheless, you dive for it at the same time as you're avoiding a falling chunk of cement.\nYou manage to make it to an exit door, and you can now leave the building.","When you tried to turn around and escape through the door you came through, a giant chunk of rubble fell directly in front of it.\nYou turned around, another giant chunk.\nIt wasn't long before the whole ceiling caved in on you.", "onecard", burtonLose);
		this.chapinBuilding = new Buildings("chapinBuilding", " \n\nYou are at Chapin House. This was the dining hall that you went to when everything else seemed a little too unappetizing to tolerate. \nThis house was also mistaken a lot for Capen House, and almost seemed to disappear in the background of a beautiful Campus Center and a stunning lawn. Are you hungry?", chapinItems);
		this.campusCenterBuilding = new Buildings("campusCenterBuilding", " \n\nYou are at the Campus Center, the oddly-shaped building that everyone enters when they first come here. \nNow, all the windows have been smashed in and it seems to be covered in a layer of soot. Do you remember all the COVID tests you took here? \nWaiting for a coffee at the Campus Cafe? \nStanding in the line for your package? \nAll of those mundane actions you realize you took for granted – will you ever be able to experience them again?", campusCenterItems);
		this.boathouseBuilding = new Buildings("boatHouseBuilding", " \n\nThe boathouse at the dock of Paradise Pond overlooks a now muddy, almost neon green body of water. \nThe stairs leading down to it are destroyed, so you have to very slowly inch your way down the steep hill. \nThere must be something useful here.", boathouseItems);
		this.collegeHallBuilding = new Buildings("collegeHallBuilding", " \n\nYou are at College Hall. The once intimidating building at the very top of the hill looks pathetic now. \nThe gates have been pried off from where they once stood, and even the steps have crumbled to unusable nothing. \nYou make your way up the hill from the other side and enter the building. \nThen, a siren that makes the hairs on your neck leap and your heart skip a beat. A loud voice starts booming over what sounds like a speakerphone. \n\nZOMBIE ON YOUR TWELVE O'CLOCK! PREPARE TO OPEN FIRE! \n\nYou don't need to hear the rest before booking it into the building. \nIs that the military? They think you're a zombie? \nThe inside of the building is completely dark, except for the light coming through the windows. The deities of this game are just going to tell you you need a flashlight, alright? If you don't have it, get it and come back.", collegeHallItems, "With your flashlight and (hopefully) poster in hand, you quickly flash the light repeatedly at the window, hoping they'll stop. The loud shooting sounds halt, and you quickly head to the exit. \nTrying to immediately run to the military right now does not seem like an option, but they are clearly the only way out of this mess. They aren't going to enter the danger zone. \nYou'll figure it out later.", "When you run outside and wave your arms around, they disengage you before you can speak. Game over.", "flashlight", collegeHallLose);
		this.mcconnellBuilding = new Buildings("mcconnellBuilding", " \n\nYou are at McConnell. Ugh. So this is what's become of the dreaded building with the extremely slow elevator and the classroom you hauled ass to every other day. Now, EVERY window is smashed in, the whole first floor ransacked. Maybe there are survivors in the classrooms, or something else at least that could be useful. You pull the door open and step in, jogging up the stairs to the back of the classroom to look at the clock. \nSuddenly, a loud and gravelly groan makes you yelp and turn around. It's Professor Jordan! Oh god, he's become a zombie! \nHe groans in a guttural and unrecognizable tone, \"Sorrrrry abouuuut Assignment twooooooooo...\" \nAnyways, let's not hurt Jordan. What's something he'd appreciate, like a little treat maybe?", mcconnellItems, "You've successfully distracted him with the candy and he hobbles away, mumbling about how you were always an incredible student. On his way out, he sort of kicks a box behind him. You pick it up. \nIt's an inflatable kiddie pool liferaft. Maybe this could be useful! You loop the handle with your backpack carabiner. You have it now.", "You tried to hurt him, you monster. Bye.", "candy", mcconnellLose); 
		this.tylerBuilding = new Buildings("tylerBuilding", " \n\nTurns out you are just really craving pasta, because that's what you're gonna get at Tyler. All those times you missed regular dinner hours and was subjected to the pesto sauce and watery lemonade... makes one shudder.", tylerItems);
		this.alumnaeGymBuilding = new Buildings("alumnaeGymBuilding", "\n\n It feels like yesterday that you were here at 2 AM, studying for your CompSci final. Wait, that WAS yesterday. You slept through the apocalypse because of a test? \n\nYou walk up to the third floor and begin to look around, maybe there's a pair of scissors or a working phone in here... oh god! Zombie hiding behind the whiteboard!", alumnaeGymItems, "Since you threw the chair so hard, the zombie was knocked onto its back and it gave you enough time to run down the stairs. Phew.", "You tried to run, but the zombie got you before you could even compile.", "chair", alumnaeGymLose);
    this.schachtCenterBuilding = new Buildings ("schachtCenterBuilding", "\n\nThe Schacht Center for Health and Wellness. The interior had that insanely unsettling Scandinavian teardrop chandelier that looked like the Michelin Man melted onto the ceiling. \nOh no! You have an injury! You didn't even realize it before, probably because of the adrenaline.", schachtCenterItems, "Before you bled out, you administered first aid onto yourself and managed to find some painkillers in the kit.", "You bled out. Goodbye, cruel world.", "firstaid", schachtCenterLose);
    this.botanicalGardenBuilding = new Buildings ("botanicalGardenBuilding", "\n\nYou're in the botanical garden. When you used to play zombie apocalypse games, you often used a crowbar or a lead pipe. What could you get from here that might work as a weapon?", botanicalGardenItems); 
    this.sageBuilding = new Buildings ("sageBuilding", "\n\nThe Sage Building, known for the choir and glee clubs, is completely desolate now. There's sheet music strewn all over the floor and the pianos are smashed. Interestingly enough, there is a vintage record player sitting in the front of the concert hall. \n Agh! There are zombies in the room! They're dressed in all black; maybe they are music-loving zombies? Oh no, they've noticed you!", sageItems, "The zombies seem annoyed with what you've done, and sort of just... retreat in utter disdain. You sneak back towards the exit; that was definitely a close one. Trying to take on four zombies at once would've been a bad idea.", "You tried to take on four zombies at once? Who do you think you are, Joel from The Last of Us? What kind of game do you think this is? You make like Beethoven and start de-composing.", "music", sageLose);
    this.hillyerBuilding = new Buildings ("hillyerBuilding", "\n\nYou walk into the art museum, trying to get a view on where the military encampments are. You happen to see one of your own art pieces from a class you took still on the wall, reminding you of the times you used to suffer in Drawing 1 because your creative abilities end at hunching over a computer in the darkness. \nYou spot a certain book sitting near the reception desk, a book called \n\n\"Computer Graphics: Implementation and Explanation\"\n by Jules Bloomenthal. That sounds like a book Nick would enjoy.", hillyerItems); 
		this.fordBuilding = new Buildings ("fordBuilding","\n\nYou go up the stairs to try and see if any of the labs have something useful for self-defense, but they are all locked, unfortunately. You wander around up to the third floor, then walk into the Computer Science department. The door to Nick's Office is open! \n\nWithout thinking, you push the door open...\n\nAAAAAAAAAAAAH! Nick is here and he's a zombie! You see hundreds, maybe even thousands of books strewn all over the floor. \n\nMaybe he wants to read something? He always did love his computer science books. We shouldn't hurt him.", fordItems, "You successfully placate Zombie Nick and he sits back down at his desk. You back up slowly, not to surprise him in any way. Your foot touches something on the floor, which is a box labeled \n\n\"In the event of an emergency.\" Well, this is most definitely an emergency. You open the box and see that there is a flare gun inside. You put the flare gun in your pocket, not your backpack. You have it though." ,"You tried to hurt him, you monster. Bye.", "book", fordLose);

		// 4 - creates Buildings[] that list the buildings in each area
		Buildings[] chapinLawnBuildings = { chapinBuilding, campusCenterBuilding };
		Buildings[] upperShoreBuildings = { boathouseBuilding, botanicalGardenBuilding };
		Buildings[] middleShoreBuildings = { mcconnellBuilding };
		Buildings[] lowerShoreBuildings = { sageBuilding };
		Buildings[] presHouseBuildings = {};
		Buildings[] burtonLawnBuildings = { burtonBuilding };
		Buildings[] collegeHallBuildings = { collegeHallBuilding };
		Buildings[] seelyeLawnBuildings = { hillyerBuilding, seelyeBuilding, neilsonBuilding };
		Buildings[] fordBuildings = { fordBuilding, schachtCenterBuilding };
		Buildings[] greenStreetBuildings = { tylerBuilding, alumnaeGymBuilding };

		// 5 - initiates
		Area elmArea = new Area("You look out across Elm Street. Most of the dorms are in ruins, and the ones that are still standing are slowly smouldering. It looks too dangerous to go over there.",null);
		Area lakeArea = new Area("You look out across the surface of Paradise Pond. It's turned a sickly green color, and a vibrant yellow fog is slowly rising from its surface. As you watch, a goose lands in the water and spontaneously combusts. You decide against getting closer.\nIf you had a boat and an oar, you might be able to cross the lake. You might also want something to signal with, just in case you need help out there.",null);
		Area westStreetArea = new Area("You look out over West Street. The ruins of Northampton are smoking in the distance. Thirty thousand people used to live here. Now it's a ghost town.\nIt seems the military has set up a line of defense along West Street. As you inspect the barrier, you see a zombie wander out into the street. There's a sharp bang, and the zombie falls to the ground.\nYou don't think you could make it through all the barbed wire and over the barricades before the snipers stop you.",null);
		Area chapinLawnArea = new Area("You end up at the once-beautiful Chapin Lawn.\nHalf of Hillyer Hall has been burned to the ground, and the other half seems unstable. It looks like the Campus Center is mostly intact, and the door to Chapin House is open. The facade of Green Hall is still standing, but the rest of the building is in ruins. \n Nearby are Chapin House and the Campus Center.",chapinLawnBuildings);
		Area upperShoreArea = new Area("Welcome to the upper area surrounding the lake.\nThis hilly field was once covered in beautiful wildflowers. Now it's covered in corpses.\nThere are paths leading north, south, east, west. Nearby are the Boathouse and the Botanical Garden.",upperShoreBuildings);
		Area middleShoreArea = new Area("\"You are now in the area we have named Middle Shore,\" say the deities of this game. In this area is McConnell Building.", middleShoreBuildings);
		Area lowerShoreArea = new Area("You're now in the lower part of the  shore, overlooking the now-destroyed Mill River bridge. Nearby is Sage Building.", lowerShoreBuildings);
		Area presHouseArea = new Area("The area surrounding Kathy's House was always so manicured; now the garden is destroyed and the road connecting the Quad to the academic center has potholes and rips in the street.",presHouseBuildings);
		Area burtonLawnArea = new Area("The Lawn in front of Burton has never seemed so special until now, huh? \nAll the Math majors used to run here in between periods, perhaps passing by the Botanical Garden. \nThis once-boring building is now covered in macrabre graffiti, and somehow, the engraved nameplate of 'Burton Hall' has been rubbed off.",burtonLawnBuildings);
		Area collegeHallArea = new Area("The once-magnificent gates are rusted over and falling apart, and the stone sign at the bottom has been destroyed into pieces of rubble. \nThe beautiful College Hall on the hill is now a remnant, a lost memory of something that felt sacred.",collegeHallBuildings); // dunno what is nearby yet
		Area seelyeLawnArea = new Area("The Seelye Lawn looks leveled and beveled compared to the fine layer of grass it used to always have. \nThis area was once the heart of the campus, and now it's covered in trash and ash. \nNearby are Hillyer Library, Seelye Hall, and Neilson Library.", seelyeLawnBuildings);
		Area fordArea = new Area("Ford Hall's lawn looks somehow untouched, compared to the absolutely destroyed mess just a few steps away. \nThis area of the campus used to be the bane of your existence... seeing it in this context kind of makes you miss it. \nNearby is the Schacht Center and Ford, of course!", fordBuildings);
		Area greenStreetArea = new Area("Green street, notorious for housing STEM majors. \nRemember all those times you'd book it to Tyler Dining after your 10:50? \nOn this street are Tyler House and Alumnae Gym.", greenStreetBuildings);
    
		// 6 - initiates each node (and associating it with an Area and where it points)
		elm = new Node("elm", elmArea, null, null, null, null);
		lake = new Node("lake", lakeArea, null, null, null, null);
		westStreet = new Node("westStreet", westStreetArea, null, null, null, null);
		chapinLawn = new Node("chapinLawn", chapinLawnArea, null, null, null, null);
		upperShore = new Node("upperShore", upperShoreArea, null, null, null, null);
		presHouse = new Node("presHouse", presHouseArea, elm, chapinLawn, upperShore, lake);
		burtonLawn = new Node("burtonLawn", burtonLawnArea, chapinLawn, null, null, upperShore);
		seelyeLawn = new Node("seelyeLawn", seelyeLawnArea, elm, elm, null, chapinLawn);
		collegeHall = new Node("collegeHall", collegeHallArea, seelyeLawn, westStreet, null, burtonLawn);
		greenStreet = new Node("greenStreet", greenStreetArea, burtonLawn, null, null, null);
		ford = new Node("ford", fordArea, collegeHall, westStreet, westStreet, greenStreet);
		lowerShore = new Node("lowerShore", lowerShoreArea, null, null, westStreet, lake);
		middleShore = new Node("middleShore", middleShoreArea, upperShore, greenStreet, lowerShore, lake);

		chapinLawn.setNorth(elm);
		chapinLawn.setEast(seelyeLawn);
		chapinLawn.setSouth(burtonLawn);
		chapinLawn.setWest(upperShore);

		seelyeLawn.setSouth(collegeHall);

		upperShore.setNorth(presHouse);
		upperShore.setEast(burtonLawn);
		upperShore.setSouth(middleShore);
		upperShore.setWest(lake);

		burtonLawn.setEast(collegeHall);
		burtonLawn.setSouth(greenStreet);

		greenStreet.setEast(ford);
		greenStreet.setSouth(lowerShore);
		greenStreet.setWest(lowerShore);

		lowerShore.setNorth(middleShore);
		lowerShore.setEast(greenStreet);

		collegeHall.setSouth(ford);
	}

	/**
	 * determines whether a building is in the player's current area
	 * 
	 * @param currentNode Node the player's current location
	 * @param input       String the building, as a string from the user
	 * @return the building to move to (as Buildings) or null if not in area
	 */
	public Buildings isInArea(Node currentNode, String input) {
		Buildings moveTo = null;
		switch (input) { // match desired building with actual building options
			case "seelye":
				moveTo = seelyeBuilding;
				break;
			case "burton":
				moveTo = burtonBuilding;
				break;
			case "neilson":
				moveTo = neilsonBuilding;
				break;
			case "mcconnell":
				moveTo = mcconnellBuilding;
				break;
			case "chapin":
				moveTo = chapinBuilding;
				break;
			case "collegehall":
			case "college":
				moveTo = collegeHallBuilding;
				break;
			case "tyler":
				moveTo = tylerBuilding;
				break;
			case "alumnaegym":
			case "alumnae":
			case "gym":
				moveTo = alumnaeGymBuilding;
				break;
			case "hillyer":
				moveTo = hillyerBuilding;
				break;
			case "ford":
				moveTo = fordBuilding;
				break;
			case "schacht":
			case "schachtcenter":
				moveTo = schachtCenterBuilding;
				break;
			case "sage":
				moveTo = sageBuilding;
				break;
			case "boathouse":
				moveTo = boathouseBuilding;
				break;
			case "campus":
			case "campuscenter":
			case "center":
				moveTo = campusCenterBuilding;
				break;
			case "lyman":
			case "botanical":
			case "garden":
			case "plant":
			case "botanicalgarden":
				moveTo = botanicalGardenBuilding;
				break;
			default:
				; // do nothing, moveTo is already null
		}
		if (currentNode.getArea().containsB(moveTo)) { // compare moveTo to the buildings in your area
			return moveTo;
		} else {
			return null;
		}
	}

	/**
	 * returns true if node is null used for lake, elm, and westStreet
	 * 
	 * @param place Node the place the player is travelling
	 */
	public boolean isNullNode(Node place) {
		if ((place == lake) || (place == elm) || (place == westStreet)) {
			return true;
		} else {
			return false;
		}
	}

  /**
	 * @returns Buildings[] of all buildings
	 */
  public Buildings[] getAllBuildings(){
    Buildings[] test = {seelyeBuilding,neilsonBuilding,burtonBuilding,chapinBuilding, campusCenterBuilding,boathouseBuilding,collegeHallBuilding,mcconnellBuilding,tylerBuilding,alumnaeGymBuilding,botanicalGardenBuilding,sageBuilding,hillyerBuilding,fordBuilding,schachtCenterBuilding};
    return test;
  }
}