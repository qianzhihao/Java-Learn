package leetCode.Algorithms;

/**
 * @Q：
 * Regular Expression Matching
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 */

//1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//3, If p.charAt(j) == '*': 
//   here are two sub conditions:
//               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
//                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

public class Solution10 {
	public boolean isMatch(String s, String p) {

		// 如果两个字符串有一个为空，则返回 false；
	    if (s == null || p == null) {
	        return false;
	    }
	    // 新建一个布尔二维数组，两个维度大小分别比两个字符串大小大1；
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    // 如果字符串 p 的第 (i+1) 个字符为'*'且二维数组 dp 第 1 行第 i 列不为空，则将二维数组 dp 的第 1 行第 (i+2) 列赋值为1；
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    // for 循环，外层循环次数为字符串 s 的长度，内层循环次数为字符串 p 的长度；
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            // 如果字符串 p 的第 (j+1) 个字符为 '.'，则将 dpdp[i][j] 的值复制给 dp[i+1][j+1]；
	        	if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	        	// 如果字符串 p 的第 (j+1) 个字符和字符串 s 的第 (i+1) 个字符相等，则将 dpdp[i][j] 的值赋值给 dp[i+1][j+1]；
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	         // 如果字符串 p 的第 (j+1) 个字符为 '*';
	            if (p.charAt(j) == '*') {
	            	// 且 p 的第 j 个字符不等于 s 的第 (i+1) 个字符，且 p 的第 j 个字符不是'.'，则将 dp[i+1][j-1] 的值赋值给dp[i+1][j+1]；
	            	if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                }
	            	// 其他情况下，如果 dp[i+1][j] ，dp[i][j+1] 和 dp[i+1][j-1]中有一个为1，则 dp[i+1][j+1] 就为真，否则为假；
	            	else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    // 返回 dp[s.length()][p.length()] 位置上的值；
	    return dp[s.length()][p.length()];
	}
}
