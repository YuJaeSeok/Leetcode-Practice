package Leetcode001_100;

public class Leetcode029_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) return 0;
		
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		
		boolean neg;
		
		//用异或来判断符号是否不同
		neg = (dividend ^ divisor) < 0;
		long t = Math.abs((long) dividend);
		long d = Math.abs((long) divisor);
		int result = 0;
		for (int i = 31; i >= 0; i--) {
			// 找出足够大的数 2^n * divisor
			if ((t >> i) >= d) {
				// 将结果加上2^n
				result += 1 << i;
				// 将被除数减去 2^n * divisor
				t -= d << i;
			}
		}
		return neg ? -result : result;
	}

}
