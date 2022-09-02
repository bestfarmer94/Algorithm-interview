package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20 {

	static int n;
	static String[][] hallway;
	static int[] dx;
	static int[] dy;
	static int student_number;
	static String[][] hallway_clone;
	static boolean result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		hallway = new String[n][n];			// 그림자 복도
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				String str = st.nextToken();
				hallway[i][j] = str;
				if(str.equals("S")) {
					student_number++;		// 학생수 체크
				}
			}
		}
		
		dx = new int[] {-1, 0, 1, 0};		// 방향 배열
		dy = new int[] {0, 1, 0, -1};
		hallway_clone = new String[n][n];	// 상상의 큐브 복도
		
		make_object(0);
		
		if(result) {
			sb.append("YES");
		}else {
			sb.append("NO");
		}

		System.out.println(sb);
		br.close();
	}
	
	
	static void make_object(int count) {
		if(result) {
			return;
		}
		
		if(count == 3) {		// 바리케이트 3개
			int student = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					hallway_clone[i][j] = hallway[i][j];	//바리케이트 만들어 놓은 복도를 복사
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(hallway[i][j].equals("T")) {
						teacher_rush(i, j, 4);			// 그림자복도 시작
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(hallway_clone[i][j].equals("S")) {
						student++;						// 살아남은 학생수
					}
				}
			}
			
			if(student == student_number) {
				result = true;				// 전원 생존은 true 엔딩
			}
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(hallway[i][j].equals("X")) {		// 바리케이트 설치 과정
					hallway[i][j] = "O";
					make_object(count+1);
					hallway[i][j] = "X";
				}
			}
		}
	}
	
	
	static void teacher_rush(int x, int y, int way) {
		
		if(way == 4) {				// 태초의 거인 (최초)
			teacher_rush(x, y, 0);
			teacher_rush(x, y, 1);
			teacher_rush(x, y, 2);
			teacher_rush(x, y, 3);
			return;
		}
		
		x += dx[way];		// 방향 배열에 따른 위상 변화
		y += dy[way];
		
		if(x >= 0 && x < n && y >= 0 && y < n) {
			if(!hallway_clone[x][y].equals("O")) {		// 변한 위치가 object가 아니면 T 존으로 바뀌고, 그 방향으로 계속 퍼짐.
				hallway_clone[x][y] = "T";
				teacher_rush(x, y, way);
			}
		}
	}
}
