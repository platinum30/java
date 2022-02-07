package enums;

public class Calender {
	private int month;
	private int year;
	private int dayInMonth;
	private Day dayOfWeek;

	public enum Day {// set enum inside a class
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}
}
