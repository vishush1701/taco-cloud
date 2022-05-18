package tacos.domain;

public class Ingredient {
	private final String id;
	private final String name;
	private final String type;
	
	public static enum Type{
		WRAP,PROTEIN,VEGGIES,CHEESE,SAUSE;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Ingredient(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
}
