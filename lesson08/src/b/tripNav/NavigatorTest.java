package b.tripNav;

public class NavigatorTest {

	public static void main(String[] args) {
		TripNavigator nav = new TripNavigator();
		nav.addPoint(new Point(9, 0));
		nav.addPoint(new Point(10, 50));
		nav.addPoint(new Point(90, 40));
		nav.addPoint(new Point(9, 41));
		nav.displayRoute();

	}

}
