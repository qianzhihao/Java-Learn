package leetCode.Algorithms;

public class Solution6 {
/**
 * 
 * @param s
 * @param nRows
 * @return
 * 	Q: ZigZag Conversion
 * 	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:(you may want to display this pattern in a fixed font for better legibility)
 * 	P    A   H   N
 * 	A P L S I I G
 * 	Y    I    R
 * 
 * 	And then read line by line: "PAHNAPLSIIGYIR"
 *
 * 	Write the code that will take a string and make this conversion given a number of rows:
 * 
 * 	string convert(string text, int nRows);
 *
 *	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *	
 * A: 
 */


	public String convert(String s, int nRows) {
	// 新建一个字符数组，将字符串转换成一个个字符；
	char[] c = s.toCharArray();
	// 新建一个整型数 len，初始化等于字符数组 c 中元素的个数；
	int len = c.length;
	// 新建一个 StringBuffer 数组 sb ；大小为 nRows；
	StringBuffer[] sb = new StringBuffer[nRows];
	// 在每一个 sb[i] 中放一个 StringBuffer()；
	for (int i = 0; i < sb.length; i++)
		sb[i] = new StringBuffer();
	
	int i = 0;
	// while 循环，循环次数是 c 中元素的个数；
	while (i < len) {
		// 竖直向下放置字符，每次放 nRows 个字符；
		for (int idx = 0; idx < nRows && i < len; idx++)
			sb[idx].append(c[i++]);
		// 斜向上的顺序放置字符，每次放（nRows - 2）个字符；
		for (int idx = nRows - 2; idx >= 1 && i < len; idx--)
			sb[idx].append(c[i++]);
	}
	// for 循环，循环次数是 sb 的大小 - 1；每次循环将 sb[idx] 中存放的字符添加到 sb[0] 中；
	for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
	// 将 sb[0] 中的字符转换成字符串；
	return sb[0].toString();
}
	
}
