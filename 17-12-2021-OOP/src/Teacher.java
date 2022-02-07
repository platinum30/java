
public class Teacher extends Person {
	private String profession;

	public Teacher(String profession) {
		super();
		this.profession = profession;
	}

	public Teacher() {
		super();
		this.profession = Proffesion.getRandProffesion();
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Teacher [name: " + this.name + ", profession: " + profession + "]";
	}

}
