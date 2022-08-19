package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] s = br.readLine().toCharArray();
		
		int count = 1;
		
		for(int i=1; i<s.length; i++) {
			if(s[i] != s[i-1]) {
				count++;
			}
		}
		
		sb.append(count/2);
		System.out.println(sb);
		br.close();
	}
}
