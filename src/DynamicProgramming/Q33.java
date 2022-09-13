package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q33 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] result = new int[n+2];	// result[i]는 i일 시작할 때의 값.
		
		StringTokenizer st;
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<n+2; i++) {
			result[i] = Math.max(result[i], result[i-1]);
			
			if(i == n+1) {
				break;
			}
			
			if(t[i] + i < n + 2) {
				result[t[i] + i] = Math.max(result[i] + p[i], result[t[i] + i]);
			}
		}
		
		sb.append(result[n+1]);
		System.out.println(sb);
		br.close();
	}
}
