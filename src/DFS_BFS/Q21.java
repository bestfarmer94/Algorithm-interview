package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21 {

	static int n;
	static int l;
	static int r;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<=n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(0, 0);
		
		System.out.println(sb);
		br.close();
	}
	
	static void move(int group, int count) {
		
		for(int i=0; i<n+1; i++) {
			
		}
	}
}
