package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q35 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<Integer> ugly = new HashSet<Integer>();
		ugly.add(1);
		int number = 1;
		int temp;
		
		while(ugly.size() != n) {
			number++;
			temp = number;
			
			if(number%2 == 0) {
				temp /= 2;
			}else if(number%3 == 0) {
				temp /= 3;
			}else if(number%5 == 0) {
				temp /= 5;
			}else {
				continue;
			}
			
			if(ugly.contains(temp)) {
				ugly.add(number);
			}
		}
		
		sb.append(number);
		
		System.out.println(sb);
		br.close();
	}
}
