import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Data;

@Data

public class Task {
	private int id;
	private String description;
	private boolean done;
	private LocalDateTime deadline;
	private boolean alertPopped;

	public Task(int id) {
		this.id = id;

	}

	public Task(int id, String desc, LocalDateTime deadline) {
		this.id = id;
		this.description = desc;
		this.deadline = deadline;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Task " + id + "\n description: " + description + "\ndeadline:" + deadline;
	}

}
