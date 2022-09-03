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
		
		int group = 0;
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				move(i, j, group, 0);
				group++;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void move(int x, int y, int group, int count) {
		
		if(x>=0 && x<n+1 && y>=0 && y<n+1) {
			
		}
		
		for(int i=0; i<n+1; i++) {
			
		}
	}
}
