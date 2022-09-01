package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5_3 {

	static int n;
	static int m;
	static int[][] ice;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ice = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ice[i][j] == 0) {	// 훑다가 0인 지점을 만나면 그 근처의 0들을 전부 1로 만들고, count++ (한 덩이 완성)
					dfs(i, j);
					count++;
				}
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int y, int x) {		// 해당 0 주변의 0들을 모조리 1로 만들어 버리는 함수
		if(y < 0 || y >= n || x < 0 || x >= m) {
			return;
		}
		
		if(ice[y][x] == 0) {
			ice[y][x] = 1;
			dfs(x+1, y);
			dfs(x, y+1);
			dfs(x-1, y);
			dfs(x, y-1);
		}
	}
}
