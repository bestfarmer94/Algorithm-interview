package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22_SeeYouLater {
	
	static int n;
	static int[][] map;
	static int x1, x2;
	static int y1, y2;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 지금 내가 풀기는 조금 어려운 것 같다.
		// 기억해 놓자.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		x1 = 0; y1 = 0;
		x2 = 0; y2 = 1;
		
		move_turn(0);
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	
	static void move_turn(int count) {
		
		if(result != 0) {
			return;
		}
		
		move(0, 1, count);	// x방향
		move(0, -1, count);	// x방향	-1
		move(1, 1, count);	// y방향
		move(1, -1, count);	// y방향	-1
		
		turn(1, 1, count);	// 회전 하는놈, 양수 방향
		turn(1, -1, count);	// 1번 회전, 음수 방향
		turn(2, 1, count);	// 2번 회전, 양수 방향
		turn(2, -1, count);
	
	}
	
	static void move(int direction, int direction2, int count) {
		
		if(direction == 0) {
			if(direction2 > 0) {
				x1++;
				x2++;
			}else {
				x1--;
				x2--;
			}
		}else if(direction2 > 0){
			y1++;
			y2++;
		}else {
			y1--;
			y2--;
		}
		
		if(x1>=0 && x2>=0 && y1>=0 && y2>=0 && x1<n && x2<n && y1<n && y2<n) {
			if(map[x1][y1] == 0 && map[x2][y2] == 0) {
				move_turn(count+1);
			}
		}
	}
	
	static void turn(int move, int direction, int count) {
		
		if(x1 == x2) {
			if(direction == 1 && x1 < n-1) {
				if(move == 1) {
					if(map[x1+1][y1] == 0 && map[x2+1][y2] == 0) {
						x1 += 1;
						y1 = y2;
						move_turn(count+1);
					}
				}else {
					if(map[x1+1][y1] == 0 && map[x2+1][y2] == 0) {
						x1 += 1;
						y1 = y2;
						move_turn(count+1);
					}
					x2 += 1;
					y2 = y1;
				}
			}else if(direction == -1 && x1 > 0) {
				if(move == 1) {
					x1 -= 1;
					y1 = y2;
				}else {
					x2 -= 1;
					y2 = y1;
				}
			}
		}else {
			if(direction == 1 && y1 < n-1) {
				if(move == 1) {
					x1 += 1;
					y1 = y2;
				}else {
					x2 += 1;
					y2 = y1;
				}
			}else if(direction == -1 && x1 > 0) {
				if(move == 1) {
					x1 -= 1;
					y1 = y2;
				}else {
					x2 -= 1;
					y2 = y1;
				}
			}
		}
	}
}
