package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex6_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> arr = new ArrayList<Student>();
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {

				return o1.score - o2.score;
			}
			
		});

		for(int i=0; i<n; i++) {
			sb.append(arr.get(i).name).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}

class Student{
	
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}