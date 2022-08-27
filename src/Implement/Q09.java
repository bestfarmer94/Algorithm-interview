package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int result = Integer.MAX_VALUE;
		
		for(int i=1; i<=s.length()/2; i++) {
			StringBuilder sb = new StringBuilder();	// 문자열을 담을 것
			int j=0;
			String[] words = new String[s.length()/i];	// 문자열 끊는 단위들을 여기에 저장할 것
			
			while(i*(j+1) <= s.length()) {	// 단위 단어 생성, 완성이 안되면 의미가 없으니 j+1이 되었다.
				String word = "";
				
				for(int k=0; k<i; k++) {
					word += s.charAt(i*j+k);	
				}
				words[j] = word;	
				j++;
			}
			
			int l = 0;
			while(true) {	// 단어를 바로 뒤의 단어들과 비교.
				int count = 1;
				
				if(l >= words.length) {
					break;
				}
				
				for(int m=l+1; m<words.length; m++) {
					if(!words[l].equals(words[m])) {	// 단어가 다르면 break
						break;
					}else {
						count++;	// 같으면 이어서 count
					}
				}
				
				if(count != 1) {
					sb.append(count).append(words[l]);	// 중복 패턴 수 + 그 단어
				}else {
					sb.append(words[l]);	// 중복단어 없으면 그대로 출력
				}
				
				l += count;	// 중복된 곳까지는 볼 필요가 없으니 그 다음까지 넘어간다.
			}
			
			if(s.length() % i != 0) {	// 묶이지 못한 나머지 뒷부분 글자도 포함되어야 한다.
				for(int n=i*j; n<s.length(); n++) {
					sb.append(s.charAt(n));
				}
			}
			
			// 최소 길이 저장
			if(sb.length() < result) {
				result = sb.length();
			}
		}
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append(result);
		System.out.println(sb2);
		br.close();
	}
}
