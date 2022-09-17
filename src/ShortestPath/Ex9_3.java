package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex9_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 도시 갯수
		int m = Integer.parseInt(st.nextToken());	// 도로 갯수
		int c = Integer.parseInt(st.nextToken());	// 출발 도시
		
		int x, y, z;
		int[][] road = new int[m][3];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			road[i][0] = x;	// start
			road[i][1] = y;	// to
			road[i][2] = z;	// 거리
		}
		
		int[] distance = new int[n+1];
		
		int inf = (int) 1e9;
		Arrays.fill(distance, inf);	// 처음엔 모두 못가는 곳으로 처리
		distance[c] = 0;
		
		PriorityQueue<Dijkstra> pq = new PriorityQueue<Dijkstra>();
		
		pq.add(new Dijkstra(0, c));	// 거리 0, 출발지 c 로 시작.
		
		while(pq.size() != 0) {
			Dijkstra dijkstra = pq.poll();	// 하나 꺼낸다.
			
			for(int i=0; i<m; i++) {
				
				if(road[i][0] == dijkstra.getStart()) {	// 도로의 출발지점과 해당 객체의 start가 같으면.
					int new_distance = dijkstra.getDistance() + road[i][2];	// 객체의 거리와 도로의 거리를 합한 거리.
					
					if(new_distance < distance[road[i][1]]) {	// 원래의 직행 코스보다 빠르면
						distance[road[i][1]] = new_distance;
						
						pq.add(new Dijkstra(new_distance, road[i][1]));	// 바뀐 거리로 우선순위 큐에 다시 집어 넣음.
					}
				}
			}
		}
		
		int time = 0;
		int count = 0;
		
		for(int i=1; i<n+1; i++) {
			if(distance[i] != inf && distance[i] != 0) {	// 갈 수 없는 곳과 출발지 빼고.
				count++;
				time = Math.max(time, distance[i]);
			}
		}
		
		sb.append(count).append(" ").append(time);
		System.out.println(sb);
		br.close();
	}

}


//	우선순위 큐를 사용하기 위해서는 필수로 comparable 메서드를 implement 해야한다.
class Dijkstra implements Comparable<Dijkstra>{
	
	int distance;
	int start;
	
	public Dijkstra(int x, int y) {
		this.distance = x;
		this.start = y;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public int compareTo(Dijkstra o) {	// 거리가 우선순위큐의 우선순위다.
		
		if(o.distance == this.distance) {
			return this.distance - o.distance;
		}
		return this.distance - o.distance;
	}
}
