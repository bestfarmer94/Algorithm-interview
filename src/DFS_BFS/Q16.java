package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16 {

	static int n;
	static int m;
	static int[][] arr;
	static int[][] temp;
	static int result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		temp = new int[n][m];	// arr 복사
		block_virus(0);
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static void block_virus(int count) {
		
		if(count == 3) {	// 바리케이트 3개 완성
			int safezone = 0;
			
			for(int i=0; i<n; i++) {	// arr 복사
				for(int j=0; j<m; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {	// 바이러스 전염
				for(int j=0; j<m; j++) {
					if(temp[i][j] == 2) {
						spread_virus(i, j, 0);
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j] == 0) {
						safezone++;
					}
				}
			}
			
			result = Math.max(result, safezone);	// 최대 safezone 저장
			return;
		}
		
		for(int i=0; i<n; i++) {	// 바리케이트 3개 쌓기
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					block_virus(count+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	static void spread_virus(int i, int j, int count) {
		
		if(i < 0 || i >= n || j < 0 || j >= m) {
			return;
		}
		
		if(count == 0 || temp[i][j] == 0) {	// 최초에는 temp = 2라서 count를 추가했다.
			temp[i][j] = 2;
			spread_virus(i+1, j, 1);
			spread_virus(i, j+1, 1);
			spread_virus(i-1, j, 1);
			spread_virus(i, j-1, 1);
		}
	}
}
