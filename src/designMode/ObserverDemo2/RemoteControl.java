package designMode.ObserverDemo2;

public class RemoteControl {
	private static final HomeVideo homeVideo = new HomeVideo();
	
	public static void main(String[] args) throws Exception {
		HomeVideoObserver bulb = new Bulb();
		HomeVideoObserver windowCurtains = new WindowCurtains();
		HomeVideoObserver audio = new Audio();
		homeVideo.addObserver(bulb);
		homeVideo.addObserver(windowCurtains);
		homeVideo.addObserver(audio);
		
		System.out.println(">>>遥控器按下播放按钮");
		homeVideo.turn(EventMode.VIDEO);
		Thread.sleep(100);
		System.out.println(">>>100毫秒后影片播放完毕");
		homeVideo.turn(EventMode.NORMAL);
	}

}
