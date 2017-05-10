package designMode.Builder;

public class ManBuilder extends Builder {

	private Person person;
	
	public ManBuilder() {
		person = new Man();
	}
	@Override
	public void buildHead() {
		System.out.println("开始构建男人的头");
		person.setHead("男人的头");
	}
	
	@Override
	public void buildBody() {
		System.out.println("开始构建男人的身体");
		person.setBody("男人的身体");
	}
	
	@Override
	public void buildFoot() {
		System.out.println("开始构建男人的脚");
		person.setFoot("男人的脚");
	}
	
	@Override
	public Person getPerson() {
		return person;
	}
}
