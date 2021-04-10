package Leetcode001_100;

public class Leetcode029_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) return 0;
		
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		
		boolean neg;
		
		//��������жϷ����Ƿ�ͬ
		neg = (dividend ^ divisor) < 0;
		long t = Math.abs((long) dividend);
		long d = Math.abs((long) divisor);
		int result = 0;
		for (int i = 31; i >= 0; i--) {
			// �ҳ��㹻����� 2^n * divisor
			if ((t >> i) >= d) {
				// ���������2^n
				result += 1 << i;
				// ����������ȥ 2^n * divisor
				t -= d << i;
			}
		}
		return neg ? -result : result;
	}

}
