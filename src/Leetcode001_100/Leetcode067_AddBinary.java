package Leetcode001_100;

/**
 * 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 * @author DeLL
 *
 */
public class Leetcode067_AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		int num = 0;
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = num;
			sum += i >= 0 ? a.charAt(i) - '0' : 0;
			sum += j >= 0 ? b.charAt(j) - '0' : 0;
			res.append(sum % 2);
			num = sum / 2;
		}
		res.append(num == 1 ? num : "");
		return res.reverse().toString();
	}
}
