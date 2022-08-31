package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14 {

	static int n;
	static ArrayList<Integer> weak;
	static ArrayList<Integer> dist;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		weak = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			weak.add(Integer.parseInt(st.nextToken()));
		}
		
		dist = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			dist.add(Integer.parseInt(st.nextToken()));
		}
		
		int number = weak.size();
		for(int i=0; i<number; i++) {	// 일자로 map을 2배로 늘리기.
			weak.add(weak.get(i) + n);
		}
		
		answer = dist.size() + 1;
		permutation(new boolean[dist.size()], new int[dist.size()], 0);
		if(answer == dist.size() + 1) {
			answer = -1;
		}
		sb.append(answer);
		System.out.println(sb);
		br.close();
	}
	
	
	static void permutation(boolean[] visited, int[] res, int depth) {
		if(answer == 1) {
			return;
		}
		
		if(depth == dist.size()) {
			for(int i=0; i<res.length; i++) {
				System.out.print(res[i]);
			}
			System.out.println();
			check(res);
			return;
		}
		
		for(int i=0; i<dist.size(); i++) {
			if(!visited[i]) {
				res[depth] = dist.get(i);
				visited[i] = true;
				permutation(visited, res, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	
	static void check(int[] res) {
		
		for(int i=0; i<weak.size()/2; i++) {
			int j = i;
			int count = 0;
			while(weak.get(j) < weak.get(i) + n) {
				int position = weak.get(j) + res[count];
				j++;
				count++;
				
				if(position > weak.get(i) + n) {
					break;
				}
				
				while(position >= weak.get(j)) {
					if(j < weak.size()-1) {
						j++;
					}else {
						break;
					}
				}
				
				if(count == res.length) {
					break;
				}
			}
			answer = Math.min(answer, count);
		}
	}
}
