package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex4_4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, -1, 0, 1};
		
		int count = 1;
		map[y][x] = -1;
		
		while(true) {
			int turn = 0;
			while(turn < 4) {	// 턴 몇번했냐
				turn++;
				d++;
				d %= 4;
				
				int next_x = x + dx[d];
				int next_y = y + dy[d];
				
				if(map[next_y][next_x] == 1 || map[next_y][next_x] == -1) {	// 바다이거나 이동한 곳이니까 돌아라
					continue;
				}else {							// 육지니까 이동해라
					x = next_x;
					y = next_y;
					map[next_y][next_x] = -1;
					count++;
					break;
				}
			}
			
			if(turn == 4) {						// 4방향 바다
				int next_x = x - dx[d];
				int next_y = y - dy[d];
				
				if(map[next_y][next_x] == 1) {
					break;
				}else {
					x = next_x;
					y = next_y;
					continue;
				}
				
			}else {
				continue;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
