package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5_4 {

	static int n;
	static int m;
	static int[][] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
//5 6
//101010
//111111
//000001
//111111
//111111
		
		arr = new int[n+2][m+2];
		
		for(int i=1; i<n+1; i++) {
			String str = br.readLine();
			for(int j=1; j<m+1; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(1, 1));
		
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		while(arr[n][m] == 1) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(arr[nx][ny] == 1) {
					arr[nx][ny] = arr[p.x][p.y] + 1;
					q.add(new Point(nx, ny));
					System.out.println(nx + " " + ny + " " + arr[nx][ny]);
				}
				
			}
		}
		
		sb.append(arr[n][m]);
		System.out.println(sb);
		br.close();
	}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}