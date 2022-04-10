import java.util.HashMap;
/**
 * Class to represent a map of verbs, their valid noun combinations, and sentence responses to each
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
 */
public class Responses{

  HashMap<String, HashMap<String, String>> responses; //a HashMap with verb keys and mini HashMaps as values. The mini HashMaps have valid items as keys and sentence responses as values

	/**
	 * constructor for Responses 
	 */
  public Responses(){
    responses = new HashMap<String, HashMap<String, String>>();
    
    HashMap<String, String> use = new HashMap<String, String>();
    use.put("null", "What are you trying to use?\n");
    use.put("shovel", "You throw the shovel to inflict damage.\n");
    use.put("firstaid", "You are now healed!\n");
    use.put("hydroflask", "You throw the hydroflask to inflict damage!\n");
    use.put("extinguisher", "You spray the fire extinguisher around the area, and the flames are successfully quelled.\n");
    use.put("lifevest", "You put on your bright orange life vest. You are now safe from drowning!\n");
    use.put("flashlight", "You switch on your flashlight. Now you can see in the dark!\n");
    use.put("onecard", "You use the onecard.\n");
    use.put("saw", "You saw through to inflict damage.\n");
    use.put("chair", "You throw a chair to inflict damage.\n");
    use.put("holyhandgrenade", "You pull the pin of the the Holy Hand Grenade of Antioch, throw it, and count to three. One, two, FIVE! Wait, no – THREE!\n\nAn angelic chorus rings out from on high as the grenade explodes.\n");
    use.put("oar", "You gonna row or something? Alright, I guess so.\n");
		use.put("candy", "You slide some candy forward.");
    responses.put("use", use); // adds the mini HashMap use to larger HashMap response
    
		//"toss" describes the "throw" action, but we couldn't say that because throw is a keyword
    HashMap<String, String> toss = new HashMap<String, String>();
    toss.put("null", "What are you trying to throw?\n");
    toss.put("candy", "You throw the candy. Sharing is caring!\n");
    toss.put("poster", "You throw the poster.\n");
    toss.put("water","You throw water.\n"); 
    toss.put("poster", "You throw the poster. Okay...?\n");
    toss.put("flyer", "You throw the flyer. Good luck I guess?\n");
    toss.put("book", "You chuck the book. I guess you really hate Computer Graphics.\n");
    toss.put("extinguisher", "You throw the metal fire extinguisher.\n");
    toss.put("lifevest", "You throw the lifevest. Completely understandable.\n");
    toss.put("flashlight", "You throw the flashlight.\n");
    toss.put("brochure", "You throw the brochure.\n");
    toss.put("onecard", "You throw the onecard. And then you immediately pick it up, because those things are worth more than gold around here.\n");
    toss.put("leaflet", "You throw the leaflet.\n");
    toss.put("saw", "You throw the saw. Why.\n");
    toss.put("food", "You throw the food. Why.\n");
    toss.put("chair", "You throw the chair.\n");
    toss.put("hydroflask", "You chuck the hydroflask. That could do a lot of damage.");
    toss.put("shovel", "You chuck the shovel. That could do a lot of damage.");
    responses.put("throw", toss);

    HashMap<String, String> play = new HashMap<String, String>();
    play.put("null", "What are you trying to play?\n");
    play.put("music", "You play beautiful music. You think you recognize the intro, but you're not sure...\n\n\"Never gonna give you up, never gonna let you down-\"\nOkay, you definitely recognize that.\n");
    responses.put("play", play); 

    HashMap<String, String> eat = new HashMap<String, String>();
    eat.put("null", "What are you trying to eat?\n");
    eat.put("food", "Nom nom dining hall food is *so* good.\n");
    responses.put("eat", eat);

    HashMap<String, String> drink = new HashMap<String, String>();
    drink.put("water", "You drink the water and your thirst is quenched.\n"); 
    responses.put("drink", drink);
    
    HashMap<String, String> give = new HashMap<String, String>();
    give.put("candy", "You hand over the delicious candy.");
    give.put("book", "You hand over the Computer Graphics book.");
    responses.put("give", give);

    HashMap<String, String> spray = new HashMap<String, String>(); 
    spray.put("extinguisher", "You spray the extinguisher.");
    responses.put("spray", spray);
  }

  /**
	 * 
   * @param verb String the first word in the response 
   * @param object String the second word in the response 
   * @return true if response is valid
	 */
  public boolean respond(String verb, String object){
    boolean valid;
    if(responses.containsKey(verb) && responses.get(verb).containsKey(object)){
      System.out.println(responses.get(verb).get(object)); 
      valid = true; 
    }
    else{
      System.out.println("You can't do that. Try wording it a different way?\n");
      valid = false;
    }
    return valid;
  }
}