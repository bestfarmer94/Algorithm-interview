package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q28 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = n-1;
		int mid;
		int result = -1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(arr[mid] == mid) {
				result = mid;
				break;
				
			}else if(arr[mid] > mid) {
				end = mid - 1;
				
			}else {
				start = mid + 1;
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
}
