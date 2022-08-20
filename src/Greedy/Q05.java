package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q05 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] weight = new int[m+1];
		
		for(int i=0; i<n; i++) {
			weight[Integer.parseInt(st.nextToken())]++;
		}
		
		int count = 0;
		
		for(int i=1; i<m+1; i++) {
			count += (n-weight[i]) * weight[i];
		}
		
		sb.append(count/2);
		System.out.println(sb);
		br.close();
	}
}
