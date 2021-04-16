package Leetcode001_100;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 * @author DeLL
 *
 */
public class Leetcode071_SimplifyPath {
	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < paths.length; i++) {
			if (!stack.isEmpty() && paths[i].equals("..")) {
				stack.pop();
			} else if (!paths[i].equals("") && !paths[i].equals(".")
					&& !paths[i].equals("..")) {
				stack.push(paths[i]);
			}
		}
		if (stack.isEmpty()) return "/";
		String res = stack.stream().collect(Collectors.joining("/"));
		return "/" + res;
	}
}
