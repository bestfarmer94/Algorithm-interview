package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q44 {

	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int x, y, z;
		Star[] stars = new Star[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			stars[i] = new Star(i, x, y, z);	// i는 행성 넘버 개념.
		}
		
		// 메모리 초과 났다. 좌표 자체를 저장해서, 나열 하는 걸로 바꿈.
//		for(int i=0; i<n-1; i++) {
//			for(int j=i+1; j<n; j++) {
//				distance = Math.min(Math.min(Math.abs(star[i][0] - star[j][0]), Math.abs(star[i][1] - star[j][1]))
//						, Math.abs(star[i][2] - star[j][2]));
//				
//				pq.add(new Star(distance, i, j));
//			}
//		}
		
		ArrayList<Star_distance> s = new ArrayList<Star_distance>();
		
		Arrays.sort(stars, new Comparator<Star>(){		// x정렬. distance, 행성1, 행성2 저장.
			@Override
			public int compare(Star o1, Star o2) {	
				return o1.x - o2.x;
			}
		});
		
		for(int i=1; i<n; i++) {
			s.add(new Star_distance(stars[i].x - stars[i-1].x, stars[i].number, stars[i-1].number));
		}
		
		Arrays.sort(stars, (s1, s2) -> s1.y - s2.y);	// y정렬, 저장.
		
		for(int i=1; i<n; i++) {
			s.add(new Star_distance(stars[i].y - stars[i-1].y, stars[i].number, stars[i-1].number));
		}
		
		Arrays.sort(stars, (s1, s2) -> s1.z - s2.z);	// z정렬, 저장.
		
		for(int i=1; i<n; i++) {
			s.add(new Star_distance(stars[i].z - stars[i-1].z, stars[i].number, stars[i-1].number));
		}
		
		Collections.sort(s); // 거리에 대해 정렬.
		
		parent = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int result = 0;
	
		for(int i=0; i<s.size(); i++) {
			
			if(count == n-1) {	// 이미 모든 터널 완공.
				break;
			}
			
			if(find(s.get(i).a) == find(s.get(i).b)) {	// 사이클
				continue;
			}
			
			result += s.get(i).distance;
			union(s.get(i).a, s.get(i).b);
			count++;
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


class Star{		// 행성 정보 클래스
	
	int number;
	int x;
	int y;
	int z;
	
	public Star(int number, int x, int y, int z) {
		this.number = number;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Star_distance implements Comparable<Star_distance>{	// 터널 정보 클래스.
	
	int distance;
	int a;
	int b;
	
	public Star_distance(int distance, int a, int b) {
		this.distance = distance;
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Star_distance o) {
		
		return this.distance - o.distance;
	}
}
