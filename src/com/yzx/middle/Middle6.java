package com.yzx.middle;

/**
 * @author YZX
 * @date 2020��11��9��
 * @time ����10:32:56
 */

public class Middle6 {
	class Solution {
   	    public String convert(String s, int numRows) {
    	if(numRows == 1)
    		return s;
    	//��������index��
    	int minus = numRows * 2 - 2;
    	//�м�ɢ�в�
		int cent = minus - 2;
		int len = s.length();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i < numRows; ++ i) {
    		int index = i;
    		while(index < len) {
    			sb.append(s.charAt(index));
    			//������ǵ�һ�к����һ���Ҳ������һ��
    			if(i != 0 && i != numRows - 1 && index + cent < len) 
	    			sb.append(s.charAt(index + cent));
    			index += minus;
    		}
    		if(i != 0 && i != numRows - 1)
    			cent -= 2;
    	}
    	return sb.toString();
    }
}
}
