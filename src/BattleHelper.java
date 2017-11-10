import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BattleHelper {
	private static final String alphabet = "abdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int shipCounter = 0;
	
	public String getMove(String prompt) {
		String inputLine = null;
		System.out.println(prompt + " ");
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			inputLine = bf.readLine();
			if (inputLine.length() == 0) {
				return null;
			}
		} catch(IOException e) {
			System.out.println("IOException: "+ e);
		}
		return inputLine.toLowerCase();
	}
	
	public ArrayList<String> placeBattleShip(int shipSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphacoords = new String[shipSize];
		String temp = null;
		int[] coords = new int[shipSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		
		shipCounter++;
		int incr = 1;
		if((shipCounter % 2) == 1) {
			incr = gridLength;
		}
		while(!success & attempts++ < 200) {
			location = (int) (Math.random() * gridSize);
			int x = 0;
			success = true;
			while(success && x <shipSize) {
				if(grid[location] == 0) {
					coords[x++] = location;
					location += incr;
					if (location >= gridSize) {
						success = false;
					}
					if (x > 0 && (location % gridLength == 0)) {
						success = false;
					} 
				} else {
					success = false;
				}
			}
		}
		int x = 0;
		int row = 0;
		int column = 0;
		while (x < shipSize) {
			grid[coords[x]] = 1;
			row = (int)(coords[x] / gridLength);
			column = coords[x] % gridLength;
			temp = String.valueOf(alphabet.charAt(column));
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
		}
		return alphaCells;
	}
}

