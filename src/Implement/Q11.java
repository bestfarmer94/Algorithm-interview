package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		boolean[][] apple = new boolean[n][n];
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			apple[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		int[][] turn = new int[l][2];	// 방향전환 정보
		
		for(int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			
			if(input.equals("L")) {
				turn[i][1] = 0;		// L(왼쪽)
			}else {
				turn[i][1] = 1;		// D(오른쪽)
			}
		}
		
		int[][] dummy = new int[n][n];	// 몸통좌표
		int length = 1;		// 몸길이
		int direction = 1;	// 방향정보
		int x = 0; int y = 0;
		int[] dx = {0, 1, 0, -1};	// 북 동 남 서
		int[] dy = {-1, 0, 1, 0};	
		int time = 0;
		
		while(true) {
			time++;
			x += dx[direction];	// 머리 이동
			y += dy[direction];
			
			if(x >= n || x < 0 || y >= n || y < 0) {	// 벽에 부딪힘.
				break;
			}else if(dummy[y][x] > 0){	// 몸에 부딪힘.
				break;
			}
			
			if(apple[y][x]) {	// 사과 있으면 몸이 늘어남. 사과 사라짐. 머리 좌표에 몸길이 입력
				length++;
				apple[y][x] = false;
				dummy[y][x] = length;
			}else {
				for(int i=0; i<n; i++) {	// 1이상의 전체 좌표에 -1, 몸길이 수축
					for(int j=0; j<n; j++) {
						if(dummy[i][j] > 0) {
							dummy[i][j]--;
						}
					}
				}
				dummy[y][x] = length;	// 머리 좌표에 몸길이 입력
			}
			
			for(int i=0; i<l; i++) {	// 방향 틀기
				if(time == turn[i][0]) {
					if(turn[i][1] == 0) {
						direction--;
						if(direction < 0) {
							direction += 4;
						}
						break;
					}else {
						direction++;
						direction %= 4;
						break;
					}
				}
			}
		}
		
		sb.append(time);
		System.out.println(sb);
		br.close();
	}
}
