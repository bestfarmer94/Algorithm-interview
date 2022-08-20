package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// N개의 동전으로 만들 수 없는 금액의 최솟값을 구하시오.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coin);
		
		int target = 1;
		
		for(int i=0; i<n; i++) {
			if(coin[i] > target) {
				break;
			}
			
			target += coin[i];
		}

		sb.append(target);
		System.out.println(sb);
		br.close();
	}
}
