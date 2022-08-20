package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] food = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		while(k > 0) {
			k--;
			result++;
			result %= n;
			
			int count = 0;
			while(food[result] == 0) {
				result++;
				result %= n;
				count++;
				
				if(count == n) {
					break;
				}
			}
			
			if(count == n) {
				result = -2;
				break;
			}
			
			food[result]--;
		}
		
		sb.append(result-1);
		System.out.println(sb);
		br.close();
	}
}
