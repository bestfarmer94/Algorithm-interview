package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q26 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		// 우선순위큐. 자동으로 정렬한다.
		// 내림차순은 아래와 같이 표현한다고 한다.
//		PriorityQueue<Integer> card2 = new PriorityQueue<>(Collections.reverseOrder());
		// arraylist로 했다가 시간초과로 바꿨다.
		PriorityQueue<Long> card = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			card.add((long)Integer.parseInt(br.readLine()));
		}
		
		long sum;
		long result = 0;
		
		while(card.size() > 1) {
			sum = card.poll() + card.poll();
			result += sum;
			card.add(sum);
		}
		
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
}
