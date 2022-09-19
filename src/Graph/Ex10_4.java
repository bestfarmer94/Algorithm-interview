package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex10_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//5
//10 -1
//10 1 -1
//4 1 -1
//4 3 1 -1
//3 3 -1
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] time = new int[n+1];			
		int[] indegree = new int[n+1];		// 선행 강의가 있는가.
		int[][] prev = new int[n*n][2];		// 나올 수 있는 가능성 중 최대한 넓게 선언했다.
		
		int count = 0;	// 선행강의를 저장하는 행을 담당함.
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());	// 수강 시간.
			
			int a;
			while((a = Integer.parseInt(st.nextToken())) != -1) {
				indegree[i]++;			// 선행 강의수 ++
				prev[count][0] = a;		// 선행 강의
				prev[count][1] = i;		// to 강의
				count++;				// 행++.
			}
		}
		
		int[] total_time = new int[n+1];
		Queue<Lecture> q = new LinkedList<Lecture>();	// 큐는 이걸로 쓴다고 한다.
		
		for(int i=1; i<n+1; i++) {
			if(indegree[i] == 0) {				// 먼저 선행강의가 없는 강의를 큐에 넣는다.
				total_time[i] = time[i];
				q.add(new Lecture(time[i], i));
			}
		}
		
		while(!q.isEmpty()) {
			Lecture l = q.poll();
			
			for(int i=0; i<n*n; i++) {
				if(prev[i][0] == 0) {		// 저장 공간을 전부 볼 필요 없이 저장 안한 부분이 나오면, 포문 종료.
					break;
				}
				
				if(l.number == prev[i][0]) {	// 지금 큐의 강의가 선행 강의인 렉쳐를 찾는다.
					int next = prev[i][1];		// 그 강의를 next에 저장.
					indegree[next]--;			// 그 강의의 선행강의수--.
					
					if(indegree[next] == 0) {	// 선행강의 0이 되면, total_time을 저장하고 q에 추가.
						total_time[next] = Math.max(total_time[next], l.time + time[next]);
						q.add(new Lecture(total_time[next], next));
					}
				}
			}
		}

		for(int i=1; i<n+1; i++) {
			sb.append(total_time[i]).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}


class Lecture{
	
	int time;
	int number;
	
	public Lecture(int time, int number) {
		this.time = time;
		this.number = number;
	}
}