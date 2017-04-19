package chap6;

public class LinearSearch {

	public static int lineSearch(int[] list, int key) {
		for (int i = 0; i < list.length; i++) {
			if(key == list[i])
				return i;
		}
		
		return -1;
	}

}
