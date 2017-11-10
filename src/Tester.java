import java.util.ArrayList;

public class Tester {
	private BattleHelper bh = new BattleHelper();
	private ArrayList<LocationofShips> shipList = new ArrayList<LocationofShips>();
	private int numOfGuesses = 0;
	
	private void setUp() {
		LocationofShips one = new LocationofShips();
		one.setName("Carrier");
		LocationofShips two = new LocationofShips();
		two.setName("Frigate");
		LocationofShips three = new LocationofShips();
		three.setName("Submarine");
		shipList.add(one);
		shipList.add(two);
		shipList.add(three);
		
		System.out.println("Your goal: Sink three ships.");
		System.out.println("Carrier, Frigate, Submarine");
		System.out.println("The fewer number of guesses increases your overall grade");
		
		for(LocationofShips shipSet : shipList) {
			ArrayList<String> newLocation = bh.placeBattleShip(3);
			shipSet.setLocation(newLocation);
		}
	}
	private void startPlaying() {
		while(!shipList.isEmpty()) {
			String userGuess = bh.getMove("Enter a guess");
			checkGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		for (LocationofShips shipTest : shipList) {
			result = shipTest.checkHit(userGuess);
			if (result.equals("Hit!")) {
				break;
			}
			if (result.equals("Sunk")) {
				shipList.remove(shipTest);
				break;
			}
		}
		System.out.println(result);
	}
	private void finishGame() {
		System.out.println("All ships Sunk!");
		if(numOfGuesses <= 18) {
			System.out.println("It only took "+ numOfGuesses + "guesses");
			System.out.println("Grade earned: A+!");
		} else {
			System.out.println("Took to long.....");
			System.out.println("Grade earned: Fail. ^_^");
		}  
	}
	public static void main(String[] args) {
		Tester game = new Tester();
		game.setUp();
		game.startPlaying();

	}
}
