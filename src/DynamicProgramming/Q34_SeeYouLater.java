package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q34_SeeYouLater {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		int[] power = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		for(int i=1; i<n; i++) {
			if(power[i] > power[i-1]) {
				count++;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
