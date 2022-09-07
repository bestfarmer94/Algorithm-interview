package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex7_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr2 = new int[m];
 		
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<m; i++) {
			int start = 0;
			int end = n-1;
			int mid;
			String result = "no";
			
			while(start <= end) {
				mid = (start + end)/2;
				
				if(arr[mid] == arr2[i]) {
					result = "yes";
					break;
					
				}else if(arr2[i] < arr[mid]) {
					end = mid-1;
					
				}else {
					start = mid+1;
				}
			}
			
			sb.append(result).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
