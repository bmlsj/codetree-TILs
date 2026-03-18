
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {

	String name;
	int height, weight;

	Student(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Student o) {
		return this.height - o.height;
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
			int height = Integer.parseInt(split[1]);
			int weight = Integer.parseInt(split[2]);

			stud.add(new Student(name, height, weight));
		}
		
		Collections.sort(stud);

		for (Student st : stud) {
			System.out.println(st.name + " " + st.height + " " + st.weight);
		}

	}

}
