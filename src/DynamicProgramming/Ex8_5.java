package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex8_5 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] money = new int[n];
		
		for(int i=0; i<n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int[] result = new int[m+1];
		
		for(int i=2; i<m+1; i++) {
			
			for(int j: money) {
				if(j > i) {
					break;
				}
				
				if(j == i) {
					result[j] = 1;
				}
				
				if(result[i] == 0 && result[i-j] != 0) {
					result[i] = result[i-j] + 1;
				}else {
					result[i] = Math.min(result[i], result[i-j] + 1);
				}
			}
		}
		
		sb.append(result[m]);
		System.out.println(result[m] == 0 ? -1 : sb);
		br.close();
	}
}
