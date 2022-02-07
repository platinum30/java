package a;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reminder implements Comparable<Reminder> {
	private LocalDateTime expiration;
	private String text;
	private boolean important;
	private boolean popped;

	public Reminder() {
	}

	public Reminder(LocalDateTime expiration, String text, boolean important) {

		this.expiration = expiration;
		this.text = text;
		this.important = important;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reminder other = (Reminder) obj;
		return Objects.equals(expiration, other.expiration) && Objects.equals(text, other.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiration, text);
	}

	/**
	 *
	 */
	@Override
	public int compareTo(Reminder o) {
		int campare = this.expiration.compareTo(o.expiration);
		if ((campare == 0 && !this.text.equals(o.text))) {
			campare = 1;
		}
		return campare;
	}

	@Override
	public String toString() {

		return "Reminder [exp= date:" + expiration.toLocalDate() + " | time:" + expiration.toLocalTime() + ", text="
				+ text + ", popped=" + popped + "]";
	}

}
