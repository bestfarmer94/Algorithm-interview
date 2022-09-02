package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17 {

	static int n;
	static int[][] arr_clone;
	static int[][] virus_time;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];	// 최초 배열
		arr_clone = new int[n][n];		// 바이러스 퍼진 후
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				arr_clone[i][j] = a;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());	// 시간
		int x = Integer.parseInt(st.nextToken());	// 행
		int y = Integer.parseInt(st.nextToken());	// 열
		
		virus_time = new int[n][n];		// 해당 좌표에 바이러스가 도착한 시간
		
		for(int i=1; i<=k; i++) {				// 작은 숫자의 바이러스가 우선순위가 높아서 먼저 한다.
			for(int j=0; j<n; j++) {
				for(int l=0; l<n; l++) {
					if(arr[j][l] == i) {
						virus(j, l, i, 0);		
					}
				}
			}
		}
		
		int result = 0;		// 안퍼지면 0
		
		if(virus_time[x-1][y-1] <= s) {		// 해당 시간까지 도착을 못한다면 입력을 안한다.
			result = arr_clone[x-1][y-1];
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static void virus(int a, int b, int virus, int time) {
		
		if(a >= 0 && a < n && b >= 0 && b < n) {	// 좌표 벗어남.
			
			if(time == 0 || arr_clone[a][b] == 0 || time < virus_time[a][b]) {		// time = 0 : 최초,
				arr_clone[a][b] = virus;								// arr_clone[a][b] == 0 : 안퍼진 좌표라면,
				virus_time[a][b] = time;								// time < virus_time[a][b] : 더 먼저 퍼졌다면,
				
				virus(a-1, b, virus, time+1);
				virus(a, b+1, virus, time+1);
				virus(a+1, b, virus, time+1);
				virus(a, b-1, virus, time+1);
			}
		}
	}
}
