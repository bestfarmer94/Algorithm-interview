package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5_4 {

	static int n;
	static int m;
	static int[][] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		result = 0;
		bfs(0, 0, 1);
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int y, int x, int count) {
		
		if(result != 0) {	// 이미 최단경로가 완성됨.
			return;
		}
				
		if(y == n-1 && x == m-1) {	// 도착하면 저장.
			result = count;
			return;
		}
		
		if(y >= 0 && y < n && x >= 0 && x < m) {	// 도착지점이 외곽이 아닐경우만 생각
			if(arr[y][x] == 1) {	// 도착한 곳은 0으로 만들고 사방으로 일단 발걸음을 뻗음.
				arr[y][x] = 0;
				bfs(y-1, x, count+1);
				bfs(y, x+1, count+1);
				bfs(y+1, x, count+1);
				bfs(y, x-1, count+1);
			}
		}
	}
}
