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
			// 剩余左括号等于右括号，下一个只能用左括号
			getGeneratePar(s + "(", left - 1, right);
		} else {
			//否则都可以用
			if (left > 0) {
				getGeneratePar(s + "(", left - 1, right);
            }
			getGeneratePar(s + ")", left, right - 1);
		}
	}
}
