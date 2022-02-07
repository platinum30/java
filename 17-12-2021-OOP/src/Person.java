
/**
 * @author USER
 *
 */
public class Person {
	protected String name;
	protected int age;
	private final int MIN_AGE = 20;
	private final int MAX_AGE = 120;

	public Person() {
		super();
		this.name = getRandName();
		this.age = getRandAge();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	/**
	 * func set person age, if age is note a valid age(20-120), func set age to (-1)
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		if (age >= MIN_AGE && age <= MAX_AGE) {
			this.age = age;
		} else {
			this.age = -1;
		}
	}

	protected String getRandName() {
		String name;
		int rand = (int) (Math.random() * 11 + 1);
		switch (rand) {
		case 1:
			name = "Moshe";
			break;
		case 2:
			name = "David";
			break;
		case 3:
			name = "Dana";
			break;
		case 4:
			name = "Rami";
			break;
		case 5:
			name = "Ruth";
			break;
		case 6:
			name = "Daniel";
			break;
		case 7:
			name = "Or";
			break;
		case 8:
			name = "Ishay";
			break;
		case 9:
			name = "Reuven";
			break;
		case 10:
			name = "Amir";
			break;
		default:
			name = "Eldar";
		}
		return name;

	}

	protected int getRandAge() {
		int rand = (int) (Math.random() * 101 + 20);
		return rand;
	}

}
