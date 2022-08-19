package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex3_2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 내림차순 정렬 하려면 int가 아닌 Integer를 해줘야만 가능하나 보다.
		Arrays.sort(arr, Comparator.reverseOrder());
		
//		int sum = arr[0] * (m - m/(k+1)) + arr[1] * (m/(k+1));
		int sum = 0;
		
		for(int i=1; i<=m; i++) {
			if(i%(k+1) != 0) {
				sum += arr[0];
			}else {
				sum += arr[1];
			}
		}
		
		sb.append(sum);
		System.out.println(sb);
		br.close();
	}
}
