package Leetcode001_100;

import java.util.*;

public class Leetcode017_LetterCombinationsofPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<>();  //ʹ��һ���������洢���е���ĸ��Ͻ��
        if (digits == null || digits.length() == 0) return combinations;

        //��������ĸ��Ӧ��ϵ�洢��Map
        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{    //�洢Ϊ������ò���
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        
       //����һ���������洢���е���Ͻ��
        Queue<String> queue = new LinkedList<>();
        //����Digits��ȡ����Ӧ�����Ӧ����ĸ����
        for (int i = 0; i < digits.length(); i++) {
            queueLetterCombinations(queue, map.get(digits.charAt(i)));
        }
        //Ҫ�󷵻�List
        for (String s : queue) {
            combinations.add(s);
        }
        return combinations;
    }

	private void queueLetterCombinations(Queue<String> queue, String[] letters) {
		//Queue<String> queue = new LinkedList<String>();
        //��ʼ�����queueһ���ǿյģ�������ʱ��ѵ�һ���������ĸ�������
        if (queue.size() == 0) {
            for (String letter : letters) {
                queue.add(letter);
            }
        } else {
            //���ں��浽����ĸ����queue������Ȼ��ƴ���Ժ�������
	        int queueLength = queue.size(); //��¼������Ҫ���г�����ϵ�Ԫ������
	        for (int i = 0; i < queueLength; i++) {
	            String s = queue.poll();    //����ͷԪ�س�����
	            for (String letter : letters) {
	                queue.add(s + letter);  //�������Ķ���Ԫ�غ͵绰�����Ӧ����ĸ���ν���ƴ�Ӳ���ӽ�����
	            }
	        }
        }
	}
}
