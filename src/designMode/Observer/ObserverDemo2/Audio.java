package designMode.Observer.ObserverDemo2;

public class Audio implements HomeVideoObserver {
	@Override
	public void update(EventMode eventMode) {
		if (eventMode == EventMode.NORMAL) {
			System.out.println("\t>>>立体声模式播放");
		}
		if (eventMode == EventMode.VIDEO) {
			System.out.println("\t>>>环绕声模式播放");
		}
	}
}
