package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q37 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int a, b, c;
		int[][] bus = new int[m][3];
		int[][] cost = new int[n+1][n+1];
		int inf = (int) 1e9;
		Arrays.fill(cost, inf);
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			bus[i][0] = a;
			bus[i][1] = b;
			bus[i][2] = c;
			
			cost[a][b] = Math.min(cost[a][b], c);
		}
		
		
		System.out.println(sb);
		br.close();
	}
}
