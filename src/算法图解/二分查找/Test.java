package 算法图解.二分查找;

public class Test {

	public static void main(String[] args) {
		int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
		int i = BinarySearch.binarySearch(list, 2);
		System.out.println(i);
		
		int j = BinarySearch.binarySearch(list, 11);
		System.out.println(j);
		int k = BinarySearch.binarySearch(list, 12);
		System.out.println(k);
		int l = BinarySearch.binarySearch(list, 1);
		System.out.println(l);
		int m = BinarySearch.binarySearch(list, 3);
		System.out.println(m);

	}

}
