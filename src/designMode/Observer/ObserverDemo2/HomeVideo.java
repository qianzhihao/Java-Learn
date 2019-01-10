package designMode.Observer.ObserverDemo2;

import java.util.ArrayList;
import java.util.List;

public class HomeVideo {
	EventMode eventMode;
	
	List<HomeVideoObserver> observerLists = new ArrayList<HomeVideoObserver>();
	
	public void addObserver(HomeVideoObserver observer){
		observerLists.add(observer);
	}
	
	public void deleteObserver(HomeVideoObserver observer){
		observerLists.remove(observer);
	}
	
	public void notifyObserver(EventMode eventMode){
		for (HomeVideoObserver observer:observerLists) {
			observer.update(this.eventMode);
		}
	}
	
	public void turn(EventMode eventMode) {
		this.eventMode = eventMode;
		notifyObserver(eventMode);
	}

}
