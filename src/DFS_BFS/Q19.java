package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19 {

	static int n;
	static int[] number;
	static char[] operator;
	static int max;
	static int min;
	static char[] calculator;
	static boolean[] visited; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		operator = new char[n-1];		// 연산자 저장소
		
		st = new StringTokenizer(br.readLine());
		int count = 0;
		
		for(int i=0; i<4; i++) {		// 연산자 저장
			int amount = Integer.parseInt(st.nextToken());
			put_operator(i, count, amount);
			count += amount;
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		calculator = new char[n-1];		// 배열을 무작위로 섞은 배열
		visited = new boolean[n-1];		// calculator에 넣은놈을 표시하는 배열
		
		permutation(0);		// 배열 섞고, 최대/최솟값 구하는 함수.
		
		sb.append(max).append('\n');
		sb.append(min);
		System.out.println(sb);
		br.close();
	}
	
	
	static void put_operator(int oper, int start, int amount) {	// 연산자 저장 함수
		
		switch(oper) {
			case 0: for(int i=start; i<start+amount; i++) {
						operator[i] = '+';
					}
					break;
			
			case 1: for(int i=start; i<start+amount; i++) {
						operator[i] = '-';
					}
					break;
			
			case 2: for(int i=start; i<start+amount; i++) {
						operator[i] = '*';
					}
					break;
					
			case 3: for(int i=start; i<start+amount; i++) {
						operator[i] = '/';
					}
					break;
		}
	}
	
	
	static void permutation(int count) {
		
		if(count == n-1) {	// 최소/최대 구하는 함수.
			min_max();
			return;
		}
		
		for(int i=0; i<n-1; i++) {	// 연산자 섞는 함수.
			if(!visited[i]) {
				calculator[count] = operator[i];
				visited[i] = true;
				permutation(count+1);
				visited[i] = false;
			}
		}
	}
	
	
	static void min_max() {		// 최소/최대 구하는 함수.
		
		int result = number[0];
		
		for(int i=0; i<n-1; i++) {
			switch(calculator[i]) {
				case '+': result += number[i+1];
							break;
				
				case '-': result -= number[i+1];
							break;
				
				case '*': result *= number[i+1];
							break;
				
				case '/': result /= number[i+1];
							break;
			}
		}
		
		if(result > max) {
			max = result;
		}
		
		if(result < min) {
			min = result;
		}
	}
}
