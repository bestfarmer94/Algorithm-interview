package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q31 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());	// 테스트 횟수
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());	// 행
			int m = Integer.parseInt(st.nextToken());	// 열
			
			int[][] gold = new int[n][m];
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n*m; j++) {
				gold[j/m][j%m] = Integer.parseInt(st.nextToken());
			}
			
			int[][] result = new int[n][m];		// 채광
			int max = 0;
			
			for(int j=0; j<m; j++) {
				
				for(int k=0; k<n; k++) {
					
					if(j == 0) {
						result[k][0] = gold[k][0];	// 첫 열은 그 칸의 금광 수가 곧 채광량 
						continue;
					}
					
					if(k == 0) {	// 0행
						result[k][j] = Math.max(result[k][j-1], result[k+1][j-1]) + gold[k][j];
						
					}else if(k == n-1) {	// n-1 행
						result[k][j] = Math.max(result[k-1][j-1], result[k][j-1]) + gold[k][j];
						
					}else {
						result[k][j] = Math.max(Math.max(result[k-1][j-1], result[k][j-1]), result[k+1][j-1])
								+ gold[k][j];
					}
					
					if(j == m-1) {	// m-1열이면, 가장 큰 행을 찾는다. 
						max = Math.max(max, result[k][j]);
					}
				}
			}
			
			sb.append(max).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}
