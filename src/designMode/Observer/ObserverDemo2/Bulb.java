package designMode.Observer.ObserverDemo2;

public class Bulb implements HomeVideoObserver {
	@Override
	public void update(EventMode eventMode) {
		if (eventMode == EventMode.NORMAL) {
			System.out.println("\t>>>灯光调亮");
		}
		if (eventMode == EventMode.VIDEO) {
			System.out.println("\t>>>灯光调暗");
		}
	}
}
