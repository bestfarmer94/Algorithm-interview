package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q25 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		int[] stages = new int[n+2];
		
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			stages[Integer.parseInt(st.nextToken())]++;
			count++;
		}
		
		ArrayList<Fail> fail = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			fail.add(new Fail(i, (double)stages[i]/count));
			count -= stages[i];
		}
		
		Collections.sort(fail, new Comparator<Fail>() {

			@Override
			public int compare(Fail o1, Fail o2) {
				if(o2.rate > o1.rate) {
					return 1;
				}else if(o1.rate == o2.rate) {
					return o1.number - o2.number;
				}else {
					return -1;
				}
			}	
		});
		
		for(int i=0; i<n; i++) {
			sb.append(fail.get(i).number).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}

class Fail{
	
	int number;
	double rate;
	
	public Fail(int number, double rate) {
		this.number = number;
		this.rate = rate;
	}
}
