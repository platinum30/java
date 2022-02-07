package enums.solarSystem;

public enum Planet {
	// the constant instances
	MERCURY(5, 120), VENUS(7, 150), EARTH(8, 190), MARS(9, 230);

//attributes
	public final int mass;
	public int orbit;// distance from sun

	private Planet(int mass, int orbit) {// CTOR MUST BE private
		this.mass = mass;
		this.orbit = orbit;
	}

	public int getOrbit() {
		return orbit;
	}

	public void setOrbit(int orbit) {
		this.orbit = orbit;
	}
}
