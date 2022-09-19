package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10_2 {

	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//7 8
//0 1 3
//1 1 7
//0 7 6
//1 7 1
//0 3 7
//0 4 2
//0 1 1
//1 1 1

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parent[i] = i;
		}
		
		int query, a, b;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			query = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(query == 0) {
				union_parent(a, b);
			}else {
				if(find_parent(a) == find_parent(b)) {
					sb.append("YES").append('\n');
				}else {
					sb.append("NO").append('\n');
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void union_parent(int a, int b) {
		
		a = find_parent(a);
		b = find_parent(b);
		
		if(a < b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
	
	static int find_parent(int a) {
		
		if(a == parent[a]) {
			return a;
		}
		
		return parent[a] = find_parent(parent[a]);
	}
}

