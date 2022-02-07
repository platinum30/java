package a;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import lombok.Data;

@Data
public class ReminderTask extends Thread {
	private Set<Reminder> reminders = new TreeSet<>();
	private boolean MonitoringActive;

	public ReminderTask(Set<Reminder> reminders) {
		this.reminders = reminders;
	}

	@Override
	public void run() {
		System.out.println("############### reminder started ################");
		while (MonitoringActive) {
			LocalDateTime timeNow = LocalDateTime.now();
			for (Reminder reminder : reminders) {
				if (reminder.getExpiration().compareTo(timeNow) == -1 && !reminder.isPopped()) {
					if (reminder.isImportant()) {
						Thread t = new Thread(new ImportantReminderTask(reminder));
						t.start();
					} else {
						System.out.println("***** ! TASK REMINDER ! *****");
						System.out.println(reminder);
					}
					reminder.setPopped(true);
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
