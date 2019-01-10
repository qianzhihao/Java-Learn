package designMode.Observer.ObserverDemo2;

public class WindowCurtains implements HomeVideoObserver {
	@Override
	public void update(EventMode eventMode) {
		if (eventMode == EventMode.NORMAL) {
			System.out.println("\t>>>窗帘开启");
		}
		if (eventMode == EventMode.VIDEO) {
			System.out.println("\t>>>窗帘关闭");
		}
	}
}
