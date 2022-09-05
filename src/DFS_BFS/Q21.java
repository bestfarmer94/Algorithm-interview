package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21 {

	static int n;
	static int l;
	static int r;
	static int[][] a;
	static int[][] group;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	
		l = Integer.parseInt(st.nextToken());	// 인구수차 최소
		r = Integer.parseInt(st.nextToken());	// 인구수차 최대
		
		a = new int[n][n];	// 인구수
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		group = new int[n][n];	// 인구수 교환 그룹
		
		move(0);
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static void move(int move_count) {	// move_count 는 이동 횟수.

		for(int i=0; i<n; i++) {		// 이동 그룹 초기화
			for(int j=0; j<n; j++) {
				group[i][j] = n*i + j;
			}
		}
		
		int check = 0;	// 이동이 없는지 체크
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {	// 인구수차가 조건에 맞으면 같은 그룹으로 분류
				
				if(j > 0) {
					if(Math.abs(a[i][j] - a[i][j-1]) >= l && Math.abs(a[i][j] - a[i][j-1]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i][j-1]);
						group[i][j-1] = Math.min(group[i][j], group[i][j-1]);
						check++;
					}
				}
				
				if(i > 0) {
					if(Math.abs(a[i][j] - a[i-1][j]) >= l && Math.abs(a[i][j] - a[i-1][j]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i-1][j]);
						group[i-1][j] = Math.min(group[i][j], group[i-1][j]);
						check++;
					}
				}
				
				if(j < n-1) {
					if(Math.abs(a[i][j] - a[i][j+1]) >= l && Math.abs(a[i][j] - a[i][j+1]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i][j+1]);
						group[i][j+1] = Math.min(group[i][j], group[i][j+1]);	
						check++;
					}
				}
				
				if(i < n-1) {
					if(Math.abs(a[i][j] - a[i+1][j]) >= l && Math.abs(a[i][j] - a[i+1][j]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i+1][j]);
						group[i+1][j] = Math.min(group[i][j], group[i+1][j]);
						check++;
					}
				}
			}
		}
		
		for(int j=n-1; j>=0; j--) {			// 역순으로 한번 더 해준다.
			for(int i=n-1; i>=0; i--) {
				
				if(j > 0) {
					if(Math.abs(a[i][j] - a[i][j-1]) >= l && Math.abs(a[i][j] - a[i][j-1]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i][j-1]);
						group[i][j-1] = Math.min(group[i][j], group[i][j-1]);
						check++;
					}
				}
				
				if(i > 0) {
					if(Math.abs(a[i][j] - a[i-1][j]) >= l && Math.abs(a[i][j] - a[i-1][j]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i-1][j]);
						group[i-1][j] = Math.min(group[i][j], group[i-1][j]);
						check++;
					}
				}
				
				if(j < n-1) {
					if(Math.abs(a[i][j] - a[i][j+1]) >= l && Math.abs(a[i][j] - a[i][j+1]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i][j+1]);
						group[i][j+1] = Math.min(group[i][j], group[i][j+1]);	
						check++;
					}
				}
				
				if(i < n-1) {
					if(Math.abs(a[i][j] - a[i+1][j]) >= l && Math.abs(a[i][j] - a[i+1][j]) <= r) {
						group[i][j] = Math.min(group[i][j], group[i+1][j]);
						group[i+1][j] = Math.min(group[i][j], group[i+1][j]);
						check++;
					}
				}
			}
		}
		
		if(check == 0) {	// 이동이 없었다.
			result = move_count;
			return;
		}
		
		move_count++;		// 이동 횟수 +1
		int[] sum = new int[n*n];		// 각 그룹의 총인원수
		int[] num = new int[n*n];		// 각 그룹의 나라수
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sum[group[i][j]] += a[i][j];
				num[group[i][j]]++;
			}
		}
		
		for(int i=0; i<n; i++) {		// 인구 이동.
			for(int j=0; j<n; j++) {
				a[i][j] = sum[group[i][j]] / num[group[i][j]];
			}
		}
		
		move(move_count);	// 계속된 이동.
	}
}
