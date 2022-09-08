package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q30 {

	static int n;
	static int k;
	static String[] words;
	static String[] queries;
	static int word_start;
	static int word_end;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());		// word 갯수
		k = Integer.parseInt(st.nextToken());		// query문 갯수
		
		words = new String[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			words[i] = st.nextToken();
		}
		
		queries = new String[k];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<k; i++) {
			queries[i] = st.nextToken();
		}

		Arrays.sort(words, new Comparator<String>() {	// words를 자릿수로 정렬

			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				
				return o1.length() - o2.length();
			}
		});
		
		int[] result = new int[k];						// 출력문 저장용
		
		for(int j=0; j<k; j++) {						// query문 하나씩 꺼냄.
			length_start(0, n-1, queries[j].length());	// query문과 문자열 길이 같은놈의 시작부분.
			length_end(0, n-1, queries[j].length());	// 끝부분
			
			if(word_start != -1) {						// 문자열 길이 같은 놈이 없음.
				
				String keyword = queries[j].replace("?", "");	// query문에서 ?를 떼어낸 키워드.
				
				for(int l=word_start; l<word_end+1; l++) {	// 문자열 길이 같은 부분만 훑기.
					
					if(queries[j].charAt(0) != '?') {	// query문이 뒷글자가 ?인 경우
						
						if(words[l].substring(0, keyword.length()).equals(keyword)) {	// 조건에 부합하는 경우
							result[j]++;
						}
						
					}else {
						if(words[l].substring(words[l].length()-keyword.length(),	// query문이 앞글자가 ?인 경우
								words[l].length()).equals(keyword)) {
							result[j]++;
						}
					}
				}
			}
			
			sb.append(result[j]).append(" ");	// 결과 출력.
		}
		
		System.out.println(sb);
		br.close();
	}
	
	
	static void length_start(int start, int end, int target) {	// 문자열 길이 같은 부분 중 시작점 찾기.
		
		if(start > end) {		// 문자열 길이 같은놈이 없다.
			word_start = -1;
			return;
		}
		
		int mid = (start + end) / 2;
		
		if(words[mid].length() == target) {		// 문자열 길이가 같다.
			
			if(mid == start || words[mid-1].length() < target) {	// 길이가 같은 맨 앞부분
				word_start = mid;
				
				return;
				
			}else {
				length_start(start, mid-1, target);	// 맨 앞부분을 찾아서
				
			}
			
		}else if(words[mid].length() > target) {
			length_start(start, mid-1, target);
			
		}else {
			length_start(mid+1, end, target);
		}
	}
	
	
	static void length_end(int start, int end, int target) { 	// 문자열 길이 같은 부분 중 끝부분 찾기.
		
		if(start > end) {
			word_end = -1;
			return;
		}
		
		int mid = (start + end) / 2;
		
		if(words[mid].length() == target) {
			
			if(mid == end || words[mid+1].length() > target) {
				word_end = mid;
				return;
				
			}else {
				length_end(mid+1, end, target);
			}
			
		}else if(words[mid].length() < target) {
			length_end(mid+1, end, target);
			
		}else {
			length_end(start, mid-1, target);
		}
	}
}
