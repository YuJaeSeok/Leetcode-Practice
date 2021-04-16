package Leetcode001_100;

/**
 * 实现strStr()
 * @author DeLL
 *
 */
public class Leetcode028_ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) return -1;
		
		int hLen = haystack.length();
		int nLen = needle.length();
		
		if (hLen == 0 && nLen != 0) return -1;
		if (nLen == 0) return 0;
		if (hLen < nLen) return -1;
		
		for (int start = 0; start < hLen - nLen + 1; start++) {
			if (haystack.substring(start, start + nLen).equals(needle)) {
				return start;
			}
		}
		return -1;
	}
}
