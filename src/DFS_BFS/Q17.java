package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17 {
	
	// 18405
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];	// 배열
		PriorityQueue<Virus> pq = new PriorityQueue<Virus>();
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<n+1; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				
				if(a != 0) {
					pq.add(new Virus(a, i, j, 1));
				}
			}
		}
		
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());	// 시간
		int x = Integer.parseInt(st.nextToken());	// 행
		int y = Integer.parseInt(st.nextToken());	// 열
		
		while(!pq.isEmpty()) {
			Virus v = pq.poll();
			
			for(int i=0; i<4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				if(nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
					
					if(arr[nx][ny] == 0) {
						arr[nx][ny] = v.number * 1000 + v.time;
						pq.add(new Virus(v.number, nx, ny, v.time + 1));
						
					}
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
		if(arr[x][y] > 1000) {
			if(arr[x][y]%1000 <= s) {
				sb.append(arr[x][y]/1000);
			}else {
				sb.append(0);
			}
		}else {
			sb.append(arr[x][y]);
		}
		
		System.out.println(sb);
		br.close();
	}

}

class Virus implements Comparable<Virus>{
	
	int number;
	int x;
	int y;
	int time;
	
	public Virus(int number, int x, int y, int time) {
		this.number = number;
		this.x = x;
		this.y = y;
		this.time = time;
	}

	@Override
	public int compareTo(Virus o) {
		
		if(this.time == o.time) {
			return this.number - o.number;
		}
		return this.time - o.time;
	}
	
}