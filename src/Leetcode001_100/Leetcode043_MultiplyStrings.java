package Leetcode001_100;

/**
 * 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式
 * 
 * 时间复杂度：O(mn),m、n分别是num1、num2的长度
 * 空间复杂度：O(m+n)
 * @author DeLL
 *
 */
public class Leetcode043_MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		
		// 保存计算结果
		String res = "0";
		// num2逐位与num1相乘
		for (int i = num2.length() - 1; i >= 0; i--) {
			int carry = 0;
			// 保存num2第i位数字与num1相乘的结果
			StringBuilder tmp = new StringBuilder();
			// 补0
			for (int j = 0; j < num2.length() - 1 - i; j++) {
				tmp.append(0);
			}
			int n2 = num2.charAt(i) - '0';
			// num2的第i位数字n2与num1相乘
			for (int k = num1.length() - 1; k >= 0 || carry != 0; k--) {
				int n1 = k < 0 ? 0 : num1.charAt(k) - '0';
				int product = (n1 * n2 + carry) % 10;
				tmp.append(product);
				carry = (n1 * n2 + carry) / 10;
			}
			// 将当前结果与新计算的结果求和作为新的结果
			res = addString(res, tmp.reverse().toString());
		}
		return res;
	}

	/**
	 * 对两个字符串数字进行相加，返回字符串形式的和
	 * @param res
	 * @param string
	 * @return
	 */
	private String addString(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1;
				i >= 0 || j >= 0 || carry != 0;
				i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			int sum = (x + y + carry) % 10;
			res.append(sum);
			carry = (x + y + carry) / 10;
		}
		return res.reverse().toString();
	}
}
