package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex8_2 {

	static int x;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		x = Integer.parseInt(br.readLine());

		bfs(1, 0);
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int a, int t) {
		
		if(result != 0 || a > x) {
			return;
		}
		
		if(a == x) {
			result = t;
		}
		
		bfs(5*a, t+1);
		bfs(3*a, t+1);
		bfs(2*a, t+1);
		bfs(a+1, t+1);
	}
}
