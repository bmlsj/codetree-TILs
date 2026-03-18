import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {

	String name;
	int kor, eng, math, total;

	Student(String name, int kor, int eng, int math, int total) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
	}

	@Override
	public int compareTo(Student o) {
		return this.total - o.total;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Student> stud = new ArrayList<Student>();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int score1 = sc.nextInt();
			int score2 = sc.nextInt();
			int score3 = sc.nextInt();
			int total = score1 + score2 + score3;
			stud.add(new Student(name, score1, score2, score3, total));
		}

		Collections.sort(stud);

		for (Student st : stud) {
			System.out.println(st.name + " " + st.kor + " " + st.eng + " " + st.math);
		}

	}

}
