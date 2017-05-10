package designMode.Builder;

public abstract class Builder {

	public abstract void buildHead();
	public abstract void buildBody();
	public abstract void buildFoot();
	
	public abstract Person getPerson();
	
}
