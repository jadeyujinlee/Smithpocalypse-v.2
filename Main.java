import java.util.Scanner;
import java.io.IOException;

/**
 * Main class. Opens a scanner, runs the game, then closes the scanner.
 *
 * @author Anna Wilson, Skye Worster, Jade Lee
 * @version Fall 2021
 */
class Main {

	/**
	 * Method that runs the game
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Play game = new Play(sc);
		sc.close();
	}
}