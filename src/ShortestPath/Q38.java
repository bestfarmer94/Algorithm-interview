package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q38 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] rank = new int[n+1][n+1];
		
		int inf = 123456789;
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == j) {
					rank[i][j] = 0;
				}else {
					rank[i][j] = inf;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());								// 중요한 건 도달할 수 있는가.
			rank[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;	// 숫자에 의미는 없다.
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == j) 	continue;
				
				for(int k=1; k<n+1; k++) {
					if(k != i || j != k) {
						rank[j][k] = Math.min(rank[j][k], rank[j][i] + rank[i][k]);	// 거쳐서 도달이 가능한가.
					}
				}
			}
		}
		
		int result = 0;
		
		for(int i=1; i<n+1; i++) {
			int count = 0;
			
			for(int j=1; j<n+1; j++) {
				if(rank[i][j] == inf && rank[j][i] == inf) {	// i j 두개가 양방향으로 inf인 것만 아니면 비교가 가능하다.
					count++;
					break;
				}
			}
			
			if(count == 0) {
				result++;
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
}
