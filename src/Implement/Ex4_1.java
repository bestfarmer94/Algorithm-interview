package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex4_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int x = 1, y =1;
		
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		String[] move = {"L", "R", "U", "D"};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int after_x = x;
			int after_y = y;
			String direction = st.nextToken();
			
			for(int i=0; i<4; i++) {
				if(direction.equals(move[i])) {
					after_x += dx[i];
					after_y += dy[i];
				}
			}
			
			if(after_x == 0 || after_x > n || after_y == 0 || after_y > n) {
				continue;
			}
			
			x = after_x;
			y = after_y;
		}
		
		sb.append(x).append(' ').append(y);
		
		System.out.println(sb);
		br.close();
	}
}
