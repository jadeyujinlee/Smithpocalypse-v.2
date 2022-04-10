import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * methods for saving and loading
 */
public class Save {

	/** constructor for save. does nothing, because all the methods are static. */
	public Save() {
	}

	/** main method. does nothing, but break if not included. */
	public static void main(String[] args) {
	}

	/**
	 * takes the current game information and writes it to a text file
	 * 
	 * @param inventory       ArrayList<String>
	 * @param currentNode     String
	 * @param currentBuilding String
	 * @param itemsList       String[][]
	 * @param completedB      boolean[]
	 * @param abilities       ArrayList<String>
	 */
	public static void writeToFile(ArrayList<String> inventory, String currentNode, String currentBuilding,String[][] itemsList, boolean[] completedB, ArrayList<String> abilities, boolean completeFord,boolean completeMcconnell) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
		for (String x : inventory) {
			bw.write(x + ",");
		}
		bw.write("\n");
		bw.write(currentNode + ",");
		bw.write(currentBuilding + "\n");
		for (String[] y : itemsList) {
			for (String z : y) {
				bw.write(z + ",");
			}
			bw.write(".");
		}
		bw.write("\n");
		for (boolean a : completedB) {
			bw.write(a + ",");
		}
		bw.write("\n");
		for (String b : abilities) {
			bw.write(b + ",");
		}
    bw.write("\n");
    bw.write(completeFord +"," +completeMcconnell);
		bw.close();
	}

	/**
	 * returns the game's previous information from a text file. each element is
	 * pulled from the file as a String[]. these arrays are then returned as one big
	 * 2D array.
	 *
	 * @return String[][] bigArray
	 */
	public static String[][] readFromFile() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("save.txt"));
		System.out.println("Loading...");
		Scanner sc = new Scanner(file);

		String[] toInventory = sc.nextLine().split(",");
		String[] toPlaces = sc.nextLine().split(",");
		String[] toItemsList = sc.nextLine().split(",");
		String[] toCompleted = sc.nextLine().split(",");
		String[] toAbilities = sc.nextLine().split(",");
    String[] toFMComplete = sc.nextLine().split(",");
		sc.close();

		String[][] bigArray = { toInventory, toPlaces, toItemsList, toCompleted, toAbilities, toFMComplete };
		return bigArray;
	}
}