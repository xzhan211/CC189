public class TestEnum {
	public static void main(String[] args) {
		for(Season s : Season.values()) {
			System.out.println(s);
		} // output: SPRING WINTER FALL SUMMER
		Season sp = Season.valueOf(Season.class, "SPRING");
		System.out.println(sp.name()); // output: SPRING
		System.out.println(sp.get()); // output: s
	}
}

enum Season{
	SPRING("s"), WINTER("w"), FALL("f"), SUMMER("s");
	private final String name;
	private Season(String name) {
		this.name = name;
	}
	public String get() {
		return name;
	}
}