package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		check_word(str);
		
		System.out.println(sb);
		br.close();
	}
	
	static void check_word(String word) {
		
		if(word.equals("")) {	// str이 다 정리 되었다.
			return;
		}
		
		int check = 0;
		int sum = 0;
		
		for(int i=0; i<word.length(); i++) {
			check = i;
			
			if(word.charAt(i) == '(') {
				sum++;
			}else {
				sum--;
			}
			
			if(sum < 0) {
				break;
			}
		}
		
		if(check == word.length()-1) {	// 정리가 다 되었다.
			sb.append(word);
			return;
		}
		
		String u ="";
		String v ="";
		
		if(check == 0) {	// 그냥 처음부터 문제다. 이보다 앞으로 진행.
			u = word;
		}else {
			for(int i=0; i<check; i++) {	// u는 살릴만 하다. 문자열 저장.
				u += word.charAt(i);
			}
			sb.append(u);
			
			for(int i=check; i<word.length(); i++) {	// 문제의 문자열.
				v += word.charAt(i);
			}
			check_word(v);
			
			return;
		}
		
		String new_word = "(";	// 재구축 문자열.
		
		for(int i=1; i<u.length()-1; i++) {	// 맨앞뒤 자르고, 문자 반전.
			if(u.charAt(i) == '(') {
				new_word += ')';
			}else {
				new_word += '(';
			}
		}
		
		new_word += ')';	// 문자열 마무리.
		check_word(new_word);
		return;
	}
}
