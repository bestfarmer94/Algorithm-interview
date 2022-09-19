package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q40 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] road = new int[m][2];
		
		for(int i=0; i<m; i++) {	// 양방향 통로
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int inf = 123456789;
		int[] distance = new int[n+1];
		Arrays.fill(distance, inf);
		distance[1] = 0;	// 출발점.
		
		PriorityQueue<Hide> pq = new PriorityQueue<Hide>();
		pq.add(new Hide(distance[1], 1));
		
		while(!pq.isEmpty()) {
			Hide h = pq.poll();
			
			for(int i=0; i<m; i++) {	// 갱신
				if(h.x == road[i][0] && h.distance + 1 < distance[road[i][1]]) {
					distance[road[i][1]] = h.distance + 1;
					pq.add(new Hide(distance[road[i][1]], road[i][1]));
				}else if(h.x == road[i][1] && h.distance + 1 < distance[road[i][0]]){
					distance[road[i][0]] = h.distance + 1;
					pq.add(new Hide(distance[road[i][0]], road[i][0]));
				}
			}
		}
		
		int x = inf;	// 최적의 좌표.
		int max = 0;	// 최적의 좌표의 거리.
		int count = 0;	// 같은 거리의 좌표 수.
		
		for(int i=1; i<n+1; i++) {
			if(distance[i] != inf) {
				
				if(distance[i] > max) {
					x = i;
					max = Math.max(max, distance[i]);
					count = 0;
				}
				
				if(distance[i] == max) {
					count++;
				}
			}
		}
		
		sb.append(x).append(" ").append(max).append(" ").append(count);
		System.out.println(sb);
		br.close();
	}
}


class Hide implements Comparable<Hide>{
	
	int distance;
	int x;
	
	public Hide(int distance, int x) {
		this.distance = distance;
		this.x = x;
	}

	@Override
	public int compareTo(Hide o) {
		
		return this.distance - o.distance;	// 오름차순
	}
}
