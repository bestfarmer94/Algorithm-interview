package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] key = new int[n][n];
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<n; j++) {
				key[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		int[][] lock = new int[m][m];
		
		for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<m; j++) {
				lock[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		int[][] key_90 = 
		
		System.out.println(sb);
		br.close();
	}
}
