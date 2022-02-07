package a;

public class ImportantReminderTask implements Runnable {
	private Reminder reminder;

	public ImportantReminderTask(Reminder reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.err.println("***** ! IMPORTANT TASK REMIND ! *****");
			System.out.println("********* (Remind #" + i + " of 3) *********\n" + reminder);
			System.err.println("*************************************");
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
