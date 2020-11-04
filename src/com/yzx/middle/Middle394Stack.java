package com.yzx.middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author YZX
 * @date 2020��11��4��
 * @time ����9:05:12
 */

public class Middle394Stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		while(sc.hasNext() && (s = sc.next())!= "0")
			System.out.println(new Middle394Stack().new Solution().decodeString(s));
	}
	class Solution {
	    public String decodeString(String s) {
			Deque<Character> alphaQueue = new LinkedList<Character>();
			Deque<Integer> digitQueue = new LinkedList<Integer>();
			StringBuffer ans = new StringBuffer(), num = new StringBuffer(), word = new StringBuffer();
			for(char c : s.toCharArray()) {
				if(Character.isDigit(c)) {
					//��¼����
					num.append(c);
				} else if(c == '['){
					//1.numתint������ջ
					digitQueue.offerLast(Integer.parseInt(num.reverse().toString()));
					num = new StringBuffer();
					//2.ջ��������ĸ��ջ		
					while(!alphaQueue.isEmpty())
						word.append(alphaQueue.pollLast());
					//3.'['��ջ
					alphaQueue.offerLast(c);
					ans.append(word.reverse());
					word = new StringBuffer();
				}
				else if(c == ']') {
					char out;
					//1.ջ��������ĸ��ջתString
					while((out = alphaQueue.pollLast()) != '[') 
						word.append(out);
					word = word.reverse();
					//2.������ջ��ȡ�ظ�����
					int cnt = digitQueue.pollLast();
					while(--cnt > 0) 
						word.append(word);
					ans.append(word);
					word = new StringBuffer();
				} else {
					//��ĸ����ĸջ
					alphaQueue.offerLast(c);
				}
			}
			while(!alphaQueue.isEmpty())
				word.append(alphaQueue.pollLast());
			ans.append(word.reverse());
	    	return ans.toString();
	    }
	}
}
