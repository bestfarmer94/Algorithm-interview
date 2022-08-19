package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3_4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		while(n != 1) {
			if(n % k == 0) {
				n /= k;
				count++;
			}else {
				n--;
				count++;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
