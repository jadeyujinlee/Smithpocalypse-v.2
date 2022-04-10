The most important part of our design was the custom objects we built. We realized that games are inherently very object oriented, and we had many specific purposes for our different objects. For example, a building contains several specific things: intro text, enemy encounter, win condition, lose condition, items contained, etc. These are the following custom objects we created:

- Node: This is an object we made that represents a place on the map. It points in the four cardinal directions, and it also holds an Area.

- Area: This object represents an area on the map, holding info about things like the Buildings that the area contains and intro text.

- Buildings: These are located within the Areas. Each Buildings object contains intro text, info about what you may encounter within that building, how to win that encounter, how to lose, and items contained in the building.

As you can see, each of these objects holds a very specific set of information, so it made the most sense to create custom objects.

NOTE: You may notice that we have employed a lot of switch cases. This is because writing a bunch of if elses is space-inefficent, takes longer to code, and to quote Anna, "looks gross." The other two concur. 

We also used some built-in classes. We used arrayLists a couple times, for the inventory and the list of abilities the player had gained. The reason for this was that it just needed to hold some strings, but it needed to be resizable because the player gains more and more items and abilities as the game progresses. In another case, we used the built in class HashMap in a funky way. This is how it was initialized:

HashMap<String, HashMap<String, String>> responses;
 
It’s a HashMap of HashMaps. The reason for this was we started out with a HasMap of just different actions (verbs) and response sentences that the computer could print out in response to them. That is obviously a key and value, as a HashMap would have. We soon realized that we needed to go a layer deeper: each verb also has a set of items that it can be said with. So, we made another HashMap within each verb, as its data.

As for alternative data structures, the main alternative we could have used was for our graph. Ours is a very base-level structure we made ourselves, with each node having four pointers, and the nodes on the edge of the map not pointing to anything (we had to prevent the player from entering these nodes). Alternatively, we could have used Guava. It would have been helpful because we wouldn’t have had to code it from scratch, but we already made our Node class before we talked about it in class, and it works just fine for our purposes. It also probably would've been a big learning curve, as we heard from other teams during Demo day.