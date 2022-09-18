package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q37 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int a, b, c;
		int[][] bus = new int[m][3];		// 노선
		int[][] cost = new int[n+1][n+1];	// cost 테이블
		int inf = (int) 1e9;
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == j) {
					cost[i][j] = 0;		// 제자리
				}else {
					cost[i][j] = inf;	// 일단 못간다고 전부 도배
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			bus[i][0] = a;
			bus[i][1] = b;
			bus[i][2] = c;
			
			cost[a][b] = Math.min(cost[a][b], c);	// 제일 싼 버스값으로 저장
		}
		
		for(int i=1; i<n+1; i++) {		// 경유지
			
			for(int j=1; j<n+1; j++) {	// 출발지
				
				if(i == j) {
					continue;
				}
				
				for(int k=1; k<n+1; k++) {	// 도착지
					if(i != k || j != k) {
						cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
					}
				}
				
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(cost[i][j] == inf) {		// 못가는건 0으로 표기 해달라고 했음.
					sb.append(0).append(" ");
				}else {
					sb.append(cost[i][j]).append(" ");
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}
