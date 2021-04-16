package Leetcode001_100;

public class Leetcode029_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) return 0;
		
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		
		boolean neg;
		
		neg = (dividend ^ divisor) < 0;
		long t = Math.abs((long) dividend);
		long d = Math.abs((long) divisor);
		int result = 0;
		for (int i = 31; i >= 0; i--) {
			if ((t >> i) >= d) {
				result += 1 << i;
				t -= d << i;
			}
		}
		return neg ? -result : result;
	}

}
