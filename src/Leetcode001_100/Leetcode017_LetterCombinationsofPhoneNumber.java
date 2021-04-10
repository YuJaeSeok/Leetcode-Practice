package Leetcode001_100;

import java.util.*;

public class Leetcode017_LetterCombinationsofPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<>();  //使用一个集合来存储所有的字母组合结果
        if (digits == null || digits.length() == 0) return combinations;

        //将号码字母对应关系存储进Map
        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{    //存储为数组更好操作
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        
       //定义一个队列来存储所有的组合结果
        Queue<String> queue = new LinkedList<>();
        //遍历Digits，取到对应号码对应的字母数组
        for (int i = 0; i < digits.length(); i++) {
            queueLetterCombinations(queue, map.get(digits.charAt(i)));
        }
        //要求返回List
        for (String s : queue) {
            combinations.add(s);
        }
        return combinations;
    }

	private void queueLetterCombinations(Queue<String> queue, String[] letters) {
		//Queue<String> queue = new LinkedList<String>();
        //初始定义的queue一定是空的，所以这时候把第一个号码的字母放入队列
        if (queue.size() == 0) {
            for (String letter : letters) {
                queue.add(letter);
            }
        } else {
            //对于后面到来字母，把queue出队列然后拼接以后进入队列
	        int queueLength = queue.size(); //记录本次需要进行出列组合的元素数量
	        for (int i = 0; i < queueLength; i++) {
	            String s = queue.poll();    //队列头元素出队列
	            for (String letter : letters) {
	                queue.add(s + letter);  //将出来的队列元素和电话号码对应的字母依次进行拼接并添加进队列
	            }
	        }
        }
	}
}
