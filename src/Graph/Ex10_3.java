package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex10_3 {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int a, b, c;
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.add(new Road(c, a, b));	// pq.add(new int[] {c, a, b}) 객체 아니고도 할수 있다. 우선순위 큐에서 우선순위 설정 필요함.
		}
		
		parent = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		int last = 0;
		
		while(!pq.isEmpty()) {
			Road r = pq.poll();
			
			if(find_parent(r.a) != find_parent(r.b)) {
				union_parent(r.a, r.b);
				result += r.cost;
				last = r.cost;
			}
		}
		
		sb.append(result - last);
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


class Road implements Comparable<Road>{
	
	int cost;
	int a;
	int b;
	
	public Road(int cost, int a, int b) {
		this.cost = cost;
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Road o) {
		
		return this.cost - o.cost;
	}
}
