package basicJavaTar;

public class Country {
	private Highway[] highways = new Highway[5];

	public Highway[] getHighways() {
		return highways;
	}

	public void setHighways(Highway[] highways) {
		this.highways = highways;
	}

	public boolean addHighway(Highway highway) {
		for (int i = 0; i < highways.length; i++) {
			if (highways[i] == null) {
				this.highways[i] = highway;
				return true;
			}
		}
		return false;
	}
}
