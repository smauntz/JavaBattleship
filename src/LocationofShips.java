import java.util.ArrayList;

public class LocationofShips {
	private ArrayList<String> locations;
	int hitsCounter;
	private String name;
	public void setName(String n) {
		n = name;
	}
	public void setLocation(ArrayList<String> l) {
		locations = l;
	}
	public String checkHit(String letterGuess) {
		int index = locations.indexOf(letterGuess);
		String result = "Miss" + index;
		if(index >= 0) {
			locations.remove(index);
			if(locations.isEmpty()) {
				result = "Sunk!";
			} else {
				result = "Hit";
			}
		}

		return result;
	}
}
