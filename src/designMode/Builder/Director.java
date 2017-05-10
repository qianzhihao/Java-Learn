package designMode.Builder;

public class Director {

	private Builder builder;
	public Director(Builder builder) {
		this.builder = builder;
	}
	public Person constructPerson() {
		builder.buildHead();
		builder.buildBody();
		builder.buildFoot();
		return builder.getPerson();
	}
}
