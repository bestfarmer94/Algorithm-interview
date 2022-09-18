package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q39 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
//		3
//		3
//		5 5 4
//		3 9 1
//		3 2 7
//		5
//		3 7 2 0 1
//		2 8 0 9 1
//		1 2 1 8 1
//		9 8 9 2 0
//		3 6 5 1 5
//		7
//		9 0 5 1 1 5 3
//		4 1 2 1 6 5 3
//		0 7 6 1 6 8 5
//		1 1 7 8 3 2 3
//		9 4 0 7 6 4 1
//		5 8 3 2 4 8 3
//		7 4 8 4 8 3 4
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int n;
		
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			int[][] energy = new int[n][n];
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					st = new StringTokenizer(br.readLine());
					energy[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Dijkstra2> pq = new PriorityQueue<Dijkstra2>();
			int x = 0;
			int y = 0;
			int[][] min = new int[n][n];
			int inf = 123456789;
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					min[j][k] = inf;
				}
			}
			
			min[0][0] = energy[0][0];
			
			pq.add(new Dijkstra2(energy[x][y], x, y));
			
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			int nx, ny;
			
			while(pq.size() != 0) {
				Dijkstra2 d = pq.poll();
				
				for(int j=0; j<4; j++) {
					nx = d.x + dx[j];
					ny = d.y + dy[j];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
						continue;
					}
					
					if(d.energy + energy[nx][ny] < min[nx][ny]) {
						min[nx][ny] = d.energy + energy[nx][ny];
						pq.add(new Dijkstra2(min[nx][ny], nx, ny));
					}
				}
			}
			
			sb.append(min[n-1][n-1]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}


class Dijkstra2 implements Comparable<Dijkstra2>{
	
	int energy;
	int x;
	int y;
	
	public Dijkstra2(int energy, int x, int y) {
		this.energy = energy;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Dijkstra2 o) {
		
		return this.energy - o.energy;
	}
}