package leetCode.Algorithms;

import java.util.HashMap;

/**
 * @author qianzhihao
 * 
 * Q: 
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * A: 
 * 
 * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
 * ����˼·�ǣ���һ���洢�ַ�����ÿ���ַ���������λ�õġ���ϣͼ����������ָ�������������Ӵ����ƶ���ָ����ɨ���ַ�����ͬʱ���¹�ϣͼ�������ָ��ָ����ַ��Ѿ����ڹ�ϣͼ�У�����ָ�������ƶ�����ͬ���ַ�λ�á�
 *
 */
public class Solution3 {
	public int LengthOfLongestSubstring(String s) {
		//����ַ���sΪ�գ��򷵻�0
		if (s.length() == 0) {
			return 0;
		}
		//�½�һ����ϣͼ map ��
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//�½����ͱ��� max �����г�ʼ�� ��
		int max = 0;
		// for ѭ����ѭ������Ϊ�ַ��� s �ĳ���
		for (int i = 0, j = 0; i < s.length(); ++i) {
			//��ȡ�ַ��� s λ�� i ���ַ� s.charAt(i) ��
			//�����ϣͼ map�а��� s.charAt(i) ����ִ�����´��� ��
			if (map.containsKey(s.charAt(i))) {
				//��ȡ�ַ� s.charAt(i) �ڹ�ϣͼ map �е� Integer ֵ���� 1 ��
					//��map.get ������������ָ������ӳ���ֵ ����
				//�� j �� map.get(s.charAt(i)) + 1 �����ĸ�ֵ�� j ��
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			//�� s.charAt(i)  �� i ��Ϊ <Character, Integer> �����ϣͼ map �� ��
			map.put(s.charAt(i), i);
			//�� max �� i - j + 1 ���������еĽϴ��߸�ֵ�� max ��
			max = Math.max(max, i - j + 1);
		}
		return max ;
	}
}
/**
������д����ע�͵�ʱ����Ϊ��������⣬�������Ŵ��ţ���Щ�ط��Ե���Щ��Ӳ�����������˰���������ͨ���еķ��롣
֮ǰ��֪��������������Ȿ�飬���Ǳ�ʹ��ڰ������������Ҹ�����˵���ҵ���������������ܴﲻ��һ���ĸ߶ȣ������������ķ��룬
������������ͨ�����ֺ�ƪ������Ҳ������ô����ȴ���ˡ���Ȼ��Щ��ְ����Ĺ���ֱ�׶�ɥʧ�˹��ĵ������������������ƴ�ͷҲ��
��������Ѫ�ģ����ǲ��ܷ��ϵģ���ѧ�������Ƿȱ������ڮ�������������׻�ת����Ŭ������������¸��ҵ���ʾ�����������������£�
���˿����������������������Ƕ����Ҹ���֪ʶ�Ļ��ۣ����ںܶ������Ż�������ôһ���ĺô��İ�
*/