
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {

	String name;
	int kor, eng, math;

	Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		if (this.kor != o.kor)
			return o.kor - this.kor;
		else if (this.eng != o.eng)
			return o.eng - this.eng;
		else
			return o.math - this.math;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Student> stud = new ArrayList<Student>();
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			String name = split[0];
			int kor = Integer.parseInt(split[1]);
			int eng = Integer.parseInt(split[2]);
			int math = Integer.parseInt(split[3]);

			stud.add(new Student(name, kor, eng, math));
		}

		Collections.sort(stud);

		for (Student st : stud) {
			System.out.println(st.name + " " + st.kor + " " + st.eng + " " + st.math);
		}

	}

}
