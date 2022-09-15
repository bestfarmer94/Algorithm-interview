package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q36 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String a = br.readLine();
		String b = br.readLine();

		// 편집거리 라는 개념이 나온다.
		// 살짝 모르면 맞아야지 문제인 것 같다.
		
		int[][] distance = new int[a.length()+1][b.length()+1];
		
		for(int i=0; i<a.length()+1; i++) {
			distance[i][0] = i;
		}
		
		System.out.print("  " + 0 + " ");
		for(int i=0; i<b.length()+1; i++) {
			distance[0][i] = i;
			if(i>=1) {
				System.out.print(b.charAt(i-1) + " ");
			}
		}
		System.out.println();
		System.out.print(0 + " ");
		
		for(int i=0; i<a.length()+1; i++) {
			
			if(i >= 1) {
				System.out.print(a.charAt(i-1) + " ");
			}
			
			for(int j=0; j<b.length()+1; j++) {
				System.out.print(distance[i][j] + " ");
			}
			
			System.out.println();
		}
		
		// 여기 까지가 기본 필드다. a = cat, b = cut 이라면.
		// distance[1][2] 를 예로 들어보면, 문자열 c와 cu의 비교가 되게 된다. u문자의 삽입이면 되므로 1이 되는 느낌이다.
		// distance[2][3] 은 똑같이 ca와 cut의 비교가 될 것이다.
		
		for(int i=1; i<a.length()+1; i++) {
			
			for(int j=1; j<b.length()+1; j++) {
				
				if(a.charAt(i-1) == b.charAt(j-1)) {	// 예를들어 t와 t의 비교를 해보자. 해당 문자는 같으니 ca와 cu의 편집거리와 같다.
					distance[i][j] = distance[i-1][j-1];
				}else {		
					// a와 u의 비교 distance[2][2]를 예로들면, distance[1][2]+1은 a를 삭제(+1)하여 c와 cu의 편집거리를 가져오는 것이고,
					// distance[2][1]+1은 ca와 c의 편집거리에서 u를 추가(+1)하는 것이다.
					// distance[1][1]+1은 위의 문자열이 같은 경우에서 실제로 문자열이 다르니까 a를 u로 교체(+1)하는 프로세스다.
					distance[i][j] = Math.min(Math.min(distance[i-1][j-1], distance[i][j-1])
							, distance[i-1][j]) + 1;
				}
			}
		}
		
		System.out.println();
		System.out.print("  " + 0 + " ");
		for(int i=0; i<b.length()+1; i++) {
			if(i>=1) {
				System.out.print(b.charAt(i-1) + " ");
			}
		}
		System.out.println();
		System.out.print(0 + " ");
		
		for(int i=0; i<a.length()+1; i++) {
			
			if(i >= 1) {
				System.out.print(a.charAt(i-1) + " ");
			}
			
			for(int j=0; j<b.length()+1; j++) {
				System.out.print(distance[i][j] + " ");
			}
			
			System.out.println();
		}
		System.out.println();
		
		sb.append(distance[a.length()][b.length()]);
		System.out.println(sb);
		br.close();
	}
}
