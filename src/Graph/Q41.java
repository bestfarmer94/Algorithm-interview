package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q41 {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

//5 4
//0 1 0 1 1
//1 0 1 1 0
//0 1 0 0 0
//1 1 0 0 0
//1 0 0 0 0
//2 3 4 3

//5 4
//0 1 0 0 1
//1 0 1 0 0
//0 1 0 0 0
//0 0 0 0 0
//1 0 0 0 0
//2 3 4 3
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		
		parent = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<n+1; j++) {							// 도시 들의 parent가 모두 같으면, 가능하다.
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					union(i, j);
				}
			}
		}

		int[] city = new int[m];
		st = new StringTokenizer(br.readLine());
		int temp = 0;
		String result = "YES";
		
		for(int i=0; i<m; i++) {
			city[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				temp = find(city[i]);
			}else {
				if(find(city[i]) != temp) {
					result = "NO";
				}
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	
	static int find(int a) {
		
		if(a == parent[a]) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	
	static void union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a < b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
}
