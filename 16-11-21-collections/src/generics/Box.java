package generics;

public class Box<T> {
	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.setContent("aaa");
		String str = box.getContent();
		System.out.println(str);
	}

}
