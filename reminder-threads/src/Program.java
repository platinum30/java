import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
	static int lastTaskId = 1;
	static Scheduler scheduler = new Scheduler();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			showMenu();
		}
	}

	public static void showMenu() {
		System.out.println("=============Welcome to task manager=============");
		System.out.println("with this app you can do the following operations");
		System.out.println("add task...................................type 1");
		System.out.println("remove task................................type 2");
		System.out.println("show all tasks.............................type 3");
		System.out.println("show tasks until...........................type 4");
		System.out.println("start monitoring...........................type 5");
		System.out.println("quite......................................type 6");
		switch (sc.nextLine()) {
		case "1":
			addTask();
			break;
		case "2":
			System.out.println(2);
			break;
		case "3":
			showAllTasks();
			break;
		case "4":
			System.out.println(4);
			break;
		default:
			System.out.println("unknown command");
		}
	}

	public static void addTask() {
		try {
			System.out.println("please type task description");
			String desc = sc.nextLine();
			System.out.println("please type task dead line date (date correct format is: yyyy-mm-dd)");
			LocalDate date = LocalDate.parse(sc.nextLine());
			System.out.println("please type task dead line time (time correct format is: hh:mm:ss)");
			LocalTime time = LocalTime.parse(sc.nextLine());
			Task task = new Task(lastTaskId++, desc, LocalDateTime.of(date, time));
			scheduler.addTask(task);
		} catch (DateTimeParseException e) {
			System.err.println(
					"add task fail due to illegal date or time format \n** correct date format is: yyyy-mm-dd  |  correct time format is: hh:mm:ss **");
		}
	}

	public static void showAllTasks() {
		if (scheduler.getAllTasks().size() == 0) {
			System.out.println("Tasks list are empty");
		} else {
			System.out.println(scheduler.getAllTasks());
		}
	}
}
