package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29 {

	static int n;
	static int c;
	static int[] house;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		house = new int[n];
		
		for(int i=0; i<n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int lo = 1;		// 공유기 최소 간격
		int hi = house[n-1] - house[0];	// 공유기 최대 간격
		int mid = 0;
		int result = 0;
		
		while(lo <= hi) {
			mid = (lo + hi) / 2;
			
			if(wifi(mid) >= c) {	// 설치된 공유기 갯수
				if(mid == hi || wifi(mid+1) < c) {	// 해당 갯수로 할 수 있는 최대 간격을 찾는 과정
					result = mid;
					break;
					
				}else{
					lo = mid + 1;	// 조금씩 거리를 높인다.
				}
				
			}else{
				hi = mid - 1;	// 간격이 너무 넓어서 조정.
				
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
	
	static int wifi(int distance) {
		
		int count = 1;
		int last_wifi = house[0];	// 마지막에 설치한 wifi 위치
		
		for(int i=1; i<n; i++) {
			
			if(house[i] - last_wifi >= distance) {
				count++;
				last_wifi = house[i];
			}
		}
		
		return count;
	}
}
