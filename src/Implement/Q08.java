package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Q08 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] s = br.readLine().toCharArray();
		
		Arrays.sort(s);
		
		// 사실 char의 아스키코드를 이용해 할 수도 있지만, 이왕 배우는거 정규 표현식의 matches를 이용해 보기로 했다.
		String pattern = "^[0-9]*$";
		int sum = 0;
		
		for(int i=0; i<s.length; i++) {
			
			String word = Character.toString(s[i]);
			// regex는 정규 표현식(Regular Expression)의 줄임말인듯 하다.
			boolean regex = Pattern.matches(pattern, word);
			
			if(regex) {
				sum += Integer.parseInt(word);
			}else {
				sb.append(s[i]);
			}
		}
		
		sb.append(sum);
		System.out.println(sb);
		br.close();
	}
}
