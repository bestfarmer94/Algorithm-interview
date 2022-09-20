package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q43 {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

//7 11
//0 1 7
//0 3 5
//1 2 8
//1 3 9
//1 4 7
//2 4 5
//3 4 15
//3 5 6
//4 5 8
//4 6 9
//5 6 11
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int x, y, z;
		PriorityQueue<Lamp> pq = new PriorityQueue<Lamp>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			pq.add(new Lamp(z, x, y));	// 거리에 대해 오름차순
		}
		
		parent = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		
		while(!pq.isEmpty()) {
			Lamp l = pq.poll();
			
			if(find(l.a) == find(l.b)) {	// 사이클. 도로 킵.
				result += l.distance;	// 절약량 저장.
				continue;
			}
			
			union(l.a, l.b);	// 연결
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


class Lamp implements Comparable<Lamp>{
	
	int distance;
	int a;
	int b;
	
	public Lamp(int distance, int a, int b) {
		this.distance = distance;
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Lamp o) {
		
		return this.distance - o.distance;
	}
}