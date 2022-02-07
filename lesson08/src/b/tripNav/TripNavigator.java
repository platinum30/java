package b.tripNav;

public class TripNavigator {
	private Point[] route = new Point[10];
	int index = 0;

	public void addPoint(Point point) {

		if (index < route.length) {
			route[index++] = point;
			// System.out.println(index);
			System.out.println("point added to route");
		} else {
			System.out.println("add point faild");
		}

	}

	public void displayRoute() {
		for (int i = 0; i < route.length; i++) {
			if (route[i] != null) {
				System.out.println(route[i]);
			}
		}
	}

}
