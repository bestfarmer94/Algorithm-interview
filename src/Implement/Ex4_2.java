package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<60; j++) {
				for(int k=0; k<60; k++) {
					if (Integer.toString(i).contains("3") || Integer.toString(j).contains("3")
							|| Integer.toString(k).contains("3")) {
						count++;
					}
				}
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
