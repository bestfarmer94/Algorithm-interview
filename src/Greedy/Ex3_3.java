package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3_3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			
			for(int j=0; j<m; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a < min) {
					min = a;
				}
			}
			
			if(min > max) {
				max = min;
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		br.close();
	}
}
