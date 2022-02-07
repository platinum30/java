import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	private List<Task> tasks = new ArrayList<>();
	private boolean monitoringActive;
	private long checkRateMilis = 1000;

	public synchronized void addTask(Task task) {
		this.tasks.add(task);
		System.out.println("task added");
	}

	public synchronized void RemoveTask(int taskId) {
		Task task = new Task(taskId);
		tasks.remove(task);
	}

	public synchronized void displayTasks() {
		System.out.println(tasks);
	}

	public synchronized Task getTask(int taskId) {
		Task task = tasks.get(taskId);
		return task;
	}

	public synchronized List<Task> getAllTasks() {
		return this.tasks;
	}

	public synchronized List<Task> getAllTasksDueUntil(LocalDateTime time) {
		List<Task> tasks = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getDeadline().isBefore(time))
				tasks.add(task);
		}
		return tasks;
	}

	public void stopMonitoring() {
		System.out.println("monitoring stoped");
		monitoringActive = false;
	}

	public void startMonitoring() {
		System.out.println("monitoring started");
		monitoringActive = true;
		SchedulerThread st = new SchedulerThread();
		st.start();
	}

	public synchronized void checkDeadLines() {
		LocalDateTime timeNow = LocalDateTime.now();
		for (Task task : tasks) {
			if (!task.isAlertPopped() && task.getDeadline().isBefore(timeNow)) {
				task.setAlertPopped(true);
				System.out.println("[" + task.getId() + "] " + task.getDescription() + " deadline past!!");
			}
		}
	}

	private class SchedulerThread extends Thread {
		@Override
		public void run() {
			System.out.println("Thread started");
			while (monitoringActive) {
				checkDeadLines();
			}
			try {
				this.sleep(checkRateMilis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
