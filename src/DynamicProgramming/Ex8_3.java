package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex8_3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] food = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[n];
		
		result[0] = food[0];
		result[1] = Math.max(food[0], food[1]);
		
		for(int i=2; i<n; i++) {
			result[i] = Math.max(result[i-1], result[i-2] + food[i]);
		}
		
		sb.append(result[n-1]);
		System.out.println(sb);
		br.close();
	}
}
