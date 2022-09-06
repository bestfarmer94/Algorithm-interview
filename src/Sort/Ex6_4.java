package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex6_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<k; i++) {
			Arrays.sort(a);
			Arrays.sort(b, Comparator.reverseOrder());
			
			if(a[0] < b[0]) {
				int temp = a[0];
				a[0] = b[0];
				b[0] = temp;
			}else {
				break;
			}
		}
		
		sb.append(Arrays.stream(a).sum());
		System.out.println(sb);
		br.close();
	}
}
