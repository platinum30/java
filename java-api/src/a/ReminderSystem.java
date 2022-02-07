package a;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ReminderSystem {
	private Set<Reminder> reminders = new TreeSet<Reminder>();
	public static Scanner sc = new Scanner(System.in);
	ReminderTask alertThread = new ReminderTask(reminders);

	public ReminderSystem() {

	}

	public synchronized void createReminder() {
		try {
			System.out.println("Please enter reminder text / description");
			String text = sc.nextLine();

			System.out.println("Please enter date (date format is: yyyy-mm-dd)");
			LocalDate date = LocalDate.parse(sc.nextLine());

			System.out.println("Please enter time (time format is: hh:mm:ss)");
			LocalTime time = LocalTime.parse(sc.nextLine());

			LocalDateTime dateTime = LocalDateTime.of(date, time);
			LocalDateTime timeNow = LocalDateTime.now();
			if (dateTime.isBefore(timeNow)) {
				System.err.println("oops, reminder time already past");
				return;
			}
			String important = "";
			boolean importantCorrectFormat = false;
			while (!importantCorrectFormat) {
				System.out.println("dues this reminder is important?");
				System.out.println("(important reminds will show up 3 times (one every minute)");
				System.out.println("enter Y / 1 if its important  or N / 0 if not. ");
				important = sc.nextLine();
				if (important.equals("1") || important.equals("0") || important.equals("Y") || important.equals("N")) {
					importantCorrectFormat = true;
					break;
				} else {
					System.err.println("oops \" " + important + " \" is not valid commad, try again");
					System.out.println("===========================================================");
				}
			}
			boolean isImportant = false;
			System.out.println(important);
			if (important.equals("1") || important.equals("Y")) {
				isImportant = true;
			}
			Reminder reminder = new Reminder(dateTime, text, isImportant);
			if (addReminder(reminder))
				System.out.println("remind added!");
			else
				System.err.println("oops, reminder wasn't added - maybe you already added remind for this task?");
		} catch (DateTimeParseException e) {
			System.err.println("Date or time format is incorrect");
		}

	}

	public synchronized boolean addReminder(Reminder reminder) {
		if (reminders.add(reminder)) {
			alertThread.setReminders(reminders);
			return true;
		} else
			return false;
	}

	public Set<Reminder> getReminders() {
		return reminders;
	}

	public synchronized void reminderMenu() {
		System.out.println("============== Welcome to reminder ==============");
		System.out.println("with this app you can do the following operations");
		System.out.println("add task...................................type 1");
		System.out.println("show all tasks.............................type 2");
		System.out.println("start reminder.............................type 3");
		System.out.println("stop reminder..............................type 4");
		System.out.println("quite......................................type 5");
		switch (sc.nextLine()) {
		case "1":
			createReminder();
			break;
		case "2":
			if (!getReminders().isEmpty()) {
				System.out.println("============ Reminds List ============");
				System.out.println(getReminders());
			} else {
				System.err.println("Reminds list are empty");
			}
			break;
		case "3":
			if (!alertThread.isMonitoringActive()) {
				alertThread.setMonitoringActive(true);
				alertThread.start();
				alertThread.setMonitoringActive(true);
			} else {
				System.err.println("Reminder is already started");
			}

			break;
		case "4":
			if (alertThread.isMonitoringActive()) {
				alertThread.setMonitoringActive(false);
				System.out.println("############### reminder stoped ################");
			} else {
				System.err.println("Reminder is not working");
			}
			break;
		case "5":
			System.out.println("Bye :(");
			System.exit(1000);
			break;
		default:
			System.err.println("unknown command");
		}
	}
}
