package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Q13 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		int[][] home = new int[2][];
		int[][] chicken = new int[2][];
		
		int count = 0;
		int count2 = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				int number = Integer.parseInt(st.nextToken());
				arr[i][j] = number;
				if(number == 1) {
					home[0][count] = i;
					home[1][count] = j;
					count++;
				}
				if(number == 2) {
					chicken[0][count2] = i;
					chicken[1][count2] = j;					
					count2++;
				}
			}
		}
		
		int result = 0;
		if(count2 <= m) {
			for(int i=0; i<count; i++) {
				int distance = Integer.MAX_VALUE;
				for(int j=0; j<count; j++) {
					distance = Math.min(distance, Math.abs(home[0][i] - chicken[0][j]));
				}
				result += distance;
			}
		}else {
			int[] have = new int[m];
			int z = 0;
			while(true) {
				
				
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static int min_distance() {
		
		int min;
		
		return min;
	}
}
