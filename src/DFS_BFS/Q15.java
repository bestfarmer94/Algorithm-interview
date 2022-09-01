package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15 {

	static int n;
	static int m;
	static int k;
	static int x;
	static int[][] road;
	static int[] city_distance;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 도시 수
		m = Integer.parseInt(st.nextToken());	// 도로 수
		k = Integer.parseInt(st.nextToken());	// 목표 거리
		x = Integer.parseInt(st.nextToken());	// 출발 도시

		road = new int[m][2];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());	// 출발
			road[i][1] = Integer.parseInt(st.nextToken());	// 도착
		}
		
		city_distance = new int[n+1];	// 출발 도시를 기준으로 한 각 도시의 최단거리
		findCity(x, 0);
		
		for(int i=0; i<n+1; i++) {		// 자동 오름차순 정렬
			if(city_distance[i] == k) {
				sb.append(i).append('\n');
			}
		}
		
		if(sb.length() == 0) {	// 그런 도시 없다.
			sb.append(-1);
		}
		
		System.out.println(sb);
		br.close();
	}

	
	static void findCity(int start, int count) {
		
		if(city_distance[start] == 0 || city_distance[start] > count) {	// 해당 도착지점의 최소소요시간을 입력
			city_distance[start] = count;
		}
		
		if(count == k) {	// 타임 오버
			return;
		}
		
		for(int i=0; i<m; i++) {
			if(road[i][0] == start) {	// 변수 start가 시작지점인 도로를 찾기
				findCity(road[i][1], count+1);	// 도로의 도착지점을 시작지점으로, count++
			}
		}
	}
}
