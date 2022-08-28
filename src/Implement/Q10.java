package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q10 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] key = new int[n][n];
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<n; j++) {
				key[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		int[][] lock = new int[m][m];
		int[][] key_lock = new int[m+2*n-2][m+2*n-2];		// 키와 자물쇠의 크기를 합친 배열
		
		for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<m; j++) {
				int a = Integer.parseInt(st.nextToken());
				lock[i][j] = a;								// 자물쇠 새기기. 사실 필요하진 않음.
				key_lock[n+i-1][n+j-1] = a;					// 중앙에도 새기기
			 }
		}
		
		boolean result = false;
		
		for(int i=0; i<m+n-1; i++) {		//키 꽂는 좌표
			if(result) {
				break;
			}
			
			for(int j=0; j<m+n-1; j++) {	
				if(result) {
					break;
				}
				
				for(int o=0; o<4; o++) {	// 키의 4 방향 회전
					if(result) {
						break;
					}
					
					int[][] new_key_lock = new int[m+2*n-2][m+2*n-2];	// 가상의 새 자물쇠 만들기
					
					for(int k=0; k<n; k++) {						// 가상의 새 자물쇠에 키를 먼저 더하고
						for(int l=0; l<n; l++) {
							new_key_lock[i+k][j+l] += key[k][l];
						}
					}
					
					HashSet<Integer> hash = new HashSet<Integer>();
					
					for(int k=0; k<m; k++) {
						for(int l=0; l<m; l++) {	//	가상의 새 자물쇠에 원래 자물쇠를 더하고
							new_key_lock[n+k-1][n+l-1] += key_lock[n+k-1][n+l-1];
							hash.add(new_key_lock[n+k-1][n+l-1]);	// hashset에 자물쇠 가운데 부분 넣고
						}
					}
					
					if(hash.size() == 1 && hash.contains(1)) {	// hashset의 모든 요소가 1인지 확인
						result = true;
					}
					
					key = turn_90(key);	// 키 90도 돌리기
				}
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static int[][] turn_90(int[][] arr){	// 90도 회전 로직
		
		int n = arr.length;
		int[][] result = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				result[j][n-i-1] = arr[i][j];
			}
		}
		
		return result;
	}
}
