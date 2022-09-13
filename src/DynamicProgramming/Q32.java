package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		int[][] triangle = new int[n][n];
		int[][] result = new int[n][n];
		int max = 0;
		
		// 엄청난 발상의 전환 아래서부터 더해서 올라간다.
//		for(int i = n-1; i>0;i--) {
//			for(int j =0; j<i;j++) {
//				arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
//			}
//		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
				
				if(i == 0) {
					result[i][j] = triangle[i][j];
					
				}else if(j == 0) {
					result[i][j] = result[i-1][j] + triangle[i][j];
					
				}else if(j == i) {
					result[i][j] = result[i-1][j-1] + triangle[i][j];
					
				}else {
					result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + triangle[i][j];
				}
				
				if(i == n-1) {
					max = Math.max(max, result[i][j]);
				}
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		br.close();
	}
}
