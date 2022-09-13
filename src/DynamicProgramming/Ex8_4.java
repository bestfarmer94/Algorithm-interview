package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex8_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] result = new int[n+1];
		
		result[1] = 1;
		result[2] = 3;
		
		for(int i=3; i<n+1; i++) {
			result[i] = result[i-1] + result[i-2] * 2;	// 세로 2줄은 result[i-1]에서 표현한 것이고
		}												// 가로 2줄과 큰 네모가 남아서 result[i-2] * 2 이다.
		
		sb.append(result[n] % 796796);
		System.out.println(sb);
		br.close();
	}
}
