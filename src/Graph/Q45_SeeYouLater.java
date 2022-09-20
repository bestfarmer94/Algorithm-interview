package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q45_SeeYouLater {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int n;
		int m;
		StringTokenizer st;

		for(int i=0; i<T; i++) {
			n = Integer.parseInt(br.readLine());
			int[] rank = new int[n+1];
			int[] new_rank = new int[n+1];
			
			for(int j=1; j<n+1; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				rank[a] = j;
				new_rank[a] = j;
			}
			
			m = Integer.parseInt(br.readLine());
			int[][] compare = new int[m][2];
			int[] indegree = new int[n+1];
			
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(rank[x] < rank[y]) {
					compare[j][0] = x;		// x가 더 순위가 높다. (숫자가 낮다.)
					compare[j][1] = y;
					indegree[y]++;
				}else {
					compare[j][0] = y;
					compare[j][1] = x;
					indegree[x]++;
				}
				
				new_rank[x] = 0;
				new_rank[y] = 0;
			}
			
			int now_rank = 1;
//			for(int k=1; k<n+1; k++) {
//				if(new_rank[k] == now_rank) {
//					now_rank++;
//				}
//			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int j=1; j<n+1; j++) {
				if(indegree[j] == 0) {
					q.add(j);
					
					break;
				}
			}
			
			if(q.isEmpty()) {
				
			}
			
			while(!q.isEmpty()) {
				int a = q.poll();
				
				for(int j=1; j<n+1; j++) {
					if(new_rank[j] == now_rank) {
						now_rank++;
					}
				}
				
				new_rank[a] = now_rank;
				now_rank++;
				
				for(int j=0; j<m; j++) {
					if(compare[j][0] == a) {
						indegree[compare[j][1]]--;
					}
					
					if(indegree[compare[j][1]] == 0) {
						q.add(j);
					}
				}
			}
			
		}
		

	}

}
