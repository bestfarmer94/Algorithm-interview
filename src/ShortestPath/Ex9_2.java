package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex9_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 도시 갯수
		int m = Integer.parseInt(st.nextToken());	// 도로 갯수
		
		int[][] road = new int[m+1][2];	// 도로
		
		for(int i=1; i<m+1; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());	// 목적지
		int k = Integer.parseInt(st.nextToken());	// 경유지
		
		int[][] distance = new int[n+1][n+1];
		
		// arrays.fill은 1차원 배열에서만 쓸수 있다고 한다.
//		Arrays.fill(distance, Integer.MAX_VALUE);
		// integer.max_value 쓰면 못가는 루트를 더할 때, max_value를 초과하는 정수가 나오게 되어 꼬인다.
		int inf = (int) 1e9;
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				distance[i][j] = inf;
			}
		}
		
		for(int i=1; i<m+1; i++) {
			distance[road[i][0]][road[i][1]] = 1;
			distance[road[i][1]][road[i][0]] = 1;
		}
		
		for(int i=1; i<n+1; i++) {
			distance[i][i] = 0;
			
			for(int j=1; j<n; j++) {
				for(int l=j+1; l<n+1; l++) {	// 양방향 도로라 그냥 j+1 부터 봐도 무방하다.
					if(j != i && l != i) {
						distance[j][l] = Math.min(distance[j][l], distance[j][i] + distance[i][l]);
						distance[l][j] = distance[j][l];
					}
				}
			}
		}
		
		int result = distance[1][k] + distance[k][x];
		
		if(result < inf) {
			sb.append(result);
		}else {
			sb.append(-1);
		}
		
		System.out.println(sb);
		br.close();
	}
}
