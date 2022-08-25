package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String n = br.readLine();
		int left = 0;
		int right = 0;
		
		for(int i=0; i<n.length(); i++) {
			if(i < n.length()/2) {
				left += n.charAt(i) -'0';
			}
			
			if(i >= n.length()/2) {
				right += n.charAt(i) -'0';
			}
		}
		
		if(left == right) {
			sb.append("LUCKY");
		}else {
			sb.append("READY");
		}
		
		System.out.println(sb);
		br.close();
	}
}
