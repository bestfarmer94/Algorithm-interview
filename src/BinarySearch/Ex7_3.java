package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex7_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] riceCake = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			riceCake[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(riceCake);
		
		int start = 0;
		int end = n-1;
		int mid = 0;
		int sum = 0;
		int cut = 0;
		int result = 0;
		
		while(start <= end) {
			mid = (start + end)/2;
			cut = riceCake[mid];
			sum = 0;
			
			for(int i=mid+1; i<n; i++) {
				sum += riceCake[i] - cut;
			}
			
			if(sum == m) {
				result = cut;
				break;
				
			}else if(sum < m) {
				end = mid-1;
				
			}else {
				start = mid+1;
			}
		}
		
		if(sum != m) {
			for(int i=riceCake[mid-1]; i<=riceCake[mid+1]; i++) {
				sum = 0;
				
				for(int j=mid; j<n; j++) {
					sum += riceCake[j] - i;
				}
				
				if(sum < m) {
					break;
				}
				
				result = i;
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
}
