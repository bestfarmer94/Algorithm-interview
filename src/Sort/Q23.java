package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q23 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student2> arr = new ArrayList<Student2>();
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Student2(st.nextToken(), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arr, new Comparator<Student2>() {

			@Override
			public int compare(Student2 o1, Student2 o2) {
				if(o1.kor == o2.kor) {
					if(o1.eng == o2.eng) {
						if(o1.math == o2.math) {
							
							return o1.name.compareTo(o2.name);
						}
						return o2.math - o1.math;
					}
					return o1.eng - o2.eng;
				}
				return o2.kor - o1.kor;
			}
		});
		
		for(int i=0; i<n; i++) {
			sb.append(arr.get(i).name).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}

class Student2{
	
	String name;
	int kor;
	int eng;
	int math;
	
	public Student2(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}
