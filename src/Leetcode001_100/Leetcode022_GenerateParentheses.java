package Leetcode001_100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode022_GenerateParentheses {
	List<String> list = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
        if (n <= 0) return list;
        
        getGeneratePar("", n, n);
        return list;
    }
	
	private void getGeneratePar(String s, int left, int right) {
		if (left == 0 && right == 0) {
			list.add(s);
			return;
		}
		
		if (left == right) {
			// ʣ�������ŵ��������ţ���һ��ֻ����������
			getGeneratePar(s + "(", left - 1, right);
		} else {
			//���򶼿�����
			if (left > 0) {
				getGeneratePar(s + "(", left - 1, right);
            }
			getGeneratePar(s + ")", left, right - 1);
		}
	}
}
