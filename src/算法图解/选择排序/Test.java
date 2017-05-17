package 算法图解.选择排序;

public class Test {

	public static void main(String[] args) {
		Integer[] list = {49, 38, 65, 97, 76, 13, 27, 14, 10};
		// 选择排序
		ChoiceSort._choiceSort(list);
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]+ " ");
		}
		System.out.println();
	}
}
