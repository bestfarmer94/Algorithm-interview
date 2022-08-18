package Greedy;

import java.io.*;
import java.util.*;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		// Q01 모험가 길드 문제.
		// 공포도X인 모험가는 X명 이상으로 구성된 그룹에만 참여 가능. 가능한 최대 그룹수를 구하라.
		// n : 모험가 수, arr : 공포도
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int group = 0;
		int count = 0;
		
		for(int i : arr) {
			group++;
			if(i <= group) {
				group = 0;
				count++;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
