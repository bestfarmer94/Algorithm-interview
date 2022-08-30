package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class point {
	
	int x;
	int y;
	
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q13 {
	
	// 실패했다.
//	static int[][] home;
//	static int[][] chicken;
	static ArrayList<point> home;
    static ArrayList<point> chicken;
	static int m;
	static int min;
	static boolean[] chicken_open;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
//		home = new int[2][];
//		chicken = new int[2][];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				int number = Integer.parseInt(st.nextToken());
				if(number == 1) {
					// 이게 안되더라...
//					home[0][count] = i;
//					home[1][count] = j;
//					count++;
					home.add(new point(i, j));
				}
				if(number == 2) {
//					chicken[0][count2] = i;
//					chicken[1][count2] = j;					
//					count2++;
					chicken.add(new point(i, j));
				}
			}
		}
		
		chicken_open = new boolean[chicken.size()];
		min = Integer.MAX_VALUE;
		
		min_distance(0, 0);
		sb.append(min);
		System.out.println(sb);
		br.close();
	}
	
	static void min_distance(int start, int count) {
		
		if(count == m) {
			int result = 0;
			
			for(int i=0; i<home.size(); i++) {
			
				int distance = Integer.MAX_VALUE;
				
				for(int j=0; j<chicken.size(); j++) {
					if(chicken_open[j]) {
						distance = Math.min(distance, 
							Math.abs(home.get(i).x - chicken.get(j).x) 
							+ Math.abs(home.get(i).y - chicken.get(j).y));
					}
				}
				
				result += distance;
			}
			
			min = Math.min(min, result);
			return;		// count = m 에서 막히게 되는 이유
		}
		
		for(int i=start; i<chicken.size(); i++) {
			chicken_open[i] = true;
			min_distance(start + 1, count + 1);	// 재귀 함수를 통해 다중 for문이 만들어 진다. 이후에 위의 count == m과 return을 통해
			chicken_open[i] = false;			// 그 이상의 생성은 막히게 된다.
		}
	}
}
