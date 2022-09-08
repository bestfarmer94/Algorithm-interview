package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = n-1;
		int mid;
		int x_start = -1;
		int x_end = -1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(arr[mid] == x) {
				if(mid == 0 || arr[mid-1] < x) {	// 배열이 out of index 나올까 걱정했는데, mid == 0 에서 참이 나오면
					x_start = mid;					// 그 뒤의 조건문은 보지도 않아서 오류 메세지가 안뜨나 보다.
					break;
				}else {
					end = mid - 1;
				}
			}else if(arr[mid] > x) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		if(x_start == -1) {
			sb.append(-1);
		}else {
			start = 0;
			end = n-1;
			
			while(start <= end) {
				mid = (start + end) / 2;
				
				if(arr[mid] == x) {
					if(mid == n-1 || arr[mid+1] > x) {
						x_end = mid;
						break;
					}else {
						start = mid + 1;
					}
				}else if(arr[mid] > x) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
			System.out.println(x_end + " " + x_start);
			sb.append(x_end - x_start + 1);
		}
		
		System.out.println(sb);
		br.close();
	}
}
