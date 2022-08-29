package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q12 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
	
		int[][] build_frame = new int[4][];
		
		String build;
		int count=0;
		while(!(build = br.readLine()).equals("")) {		// build_frame 입력 받기
			StringTokenizer st = new StringTokenizer(build);

			for(int i=0; i<4; i++) {
				build_frame[i][count] = Integer.parseInt(st.nextToken());
			}
			
			count++;
		}
		
		ArrayList<Integer>[] result = new ArrayList[3];
		for(int i=0; i<3; i++) {
			result[i] = new ArrayList<Integer>();
		}
		
		System.out.println(sb);
		br.close();
	}
	
	// 자바로 풀기가 상당히 불리한 것 같다. 처음으로 느꼈다.
	// 출력에 사용하는 2차원 배열에 저장했다가 다시 특정한 값들만 빼는 것이 상당히 힘들다.
	
//	static boolean possible(int[][] build_frame) {
//		
//		if(build_frame[3][i] == 1) {	// 설치
//			if(build_frame[2][i] == 0) {	// 기둥
//				if(y != n) {
//					if(y > 0) {
//						if(column[x][y-1]) {	// 아래에 기둥이 있을 때
//							column[x][y] = true;
//						}
//					}
//					if(x > 0){
//						if(bo[x-1][y] || bo[x][y]) {	// 보가 옆에 있을 때
//							column[x][y] = true;
//						}
//					}
//				}
//			}else {		// 보
//				if(x != n) {
//					if(y > 0) {
//						if(column[x][y-1] || column[x+1][y-1]) {	// 기둥이 양옆에 있을 때
//							bo[x][y] = true;
//						}
//					}
//					if(x > 0) {
//						if(bo[x-1][y] && bo[x+1][y]) {		// 양 옆에 보가 있을 때
//							bo[x][y] = true;
//						}
//					}
//				}
//			}
//		}
//		
//		return true;
//	}
}
