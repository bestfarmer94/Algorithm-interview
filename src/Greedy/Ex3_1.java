package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 동전 거스름돈 최소 갯수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] coin = {500, 100, 50, 10};
		int count = 0;
		
		for(int i=0; i<4; i++) {
			count += n/coin[i];
			n %= coin[i];
			if(n == 0) {
				break;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
