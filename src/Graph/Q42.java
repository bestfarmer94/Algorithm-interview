package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q42 {

	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		parent = new int[g+1];
		for(int i=1; i<g+1; i++) {
			parent[i] = i;
		}
		
		int[] air = new int[p];
		
		for(int i=0; i<p; i++) {
			air[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		
		for(int i=0; i<p; i++) {
			if(find(air[i]) == 0) {	// 운행 종료.
				break;
			}
			
			docking(air[i]);
			count++;
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
	
	
	static void docking(int a) {	// 도킹 할때마다 parent가 한칸씩 밀린다.
		
		a = find(a);
		parent[a] = a-1;
	}
	
	
	static int find(int a) {
		
		if(a == parent[a]) {
			return a;
		}
		
		return parent[a] = find(parent[a]); 
	}
}
