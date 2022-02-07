package d.object;

import java.io.Serializable;

public class Cat implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private transient int weight; // transient attribute will net serialized
	private String color;

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWight() {
		return weight;
	}

	public void setWight(int wight) {
		this.weight = wight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// CTOR
	public Cat() {

	}

//CTOR
	public Cat(int id, String name, int wight, String color) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.color = color;
	}

}
