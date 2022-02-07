package app.core.beans;

public enum Category {
	FOOD, ELECTRICITY, RESTAURANT, VACATION;

	public static Category getCatEnum(int num) {
		switch (num) {
		case 0:
			return Category.FOOD;
		case 1:
			return Category.ELECTRICITY;
		case 2:
			return Category.RESTAURANT;
		case 3:
			return Category.VACATION;
		default:
			return null;
		}
	}
}
