package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] s = br.readLine().toCharArray();
		
		int res = 0;
		
		// 한쪽이라도 1이하면 더하는게 더 크다.
		
		for(int i=0; i<s.length; i++) {
			int num = s[i] - '0';
			if(res <= 1 || num <= 1) {
				res += num;
			}else{
				res *= num;
			}
		}
		
		sb.append(res);
		System.out.println(sb);
		br.close();
	}
}
