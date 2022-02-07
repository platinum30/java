package b;

public class Person {
	private int id;
	private String name;
	protected int age;

	public Person(int id, String name, int age) throws Exception {
		super();
		this.id = id;
		this.name = name;
		setAge(age);
	}

	public void setAge(int age) throws AgeException {
		if (age >= 0 && age <= 120) {
			this.age = age;
		} else {
			AgeException e1 = new AgeException("age must be between 0-120 years");
			throw e1;
		}
	}

	public Person() {

	}

	public static void main(String[] args) {

		Person[] pArr = new Person[5];
		pArr[0] = new Person();
		pArr[1] = new Person();
		pArr[2] = new Person();

		for (int i = 0; i < pArr.length; i++) {

			try {
				int rand = (int) (Math.random() * 201);
				System.out.println(rand);
				pArr[i].setAge(rand);

			} catch (NullPointerException e) {
				System.out.println("NULL");
			} catch (AgeException e1) {
				System.out.println(e1.getMessage());
			}

			System.out.println(pArr[i].toString());
			System.out.println("++++++++++++++++++++++++++++++");
		}

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

}
