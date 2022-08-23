package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4_3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String now = br.readLine();
		
		int x = now.charAt(0) - 'a' + 1;
		int y = now.charAt(1) - '0';

		int[][] move = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
		int count = 0;
		
		for(int i=0; i<8; i++) {
			int move_x = x + move[i][0];
			int move_y = y + move[i][1];
			
			if(move_x >= 1 && move_x <= 8 && move_y >= 1 && move_y <= 8) {
				count++;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
