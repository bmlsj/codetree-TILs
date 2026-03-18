import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {

	int idx, height, weight;

	Student(int idx, int height, int weight) {
		this.idx = idx;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Student o) {
		if (o.height != this.height)
			return o.weight - this.weight;
		else if (o.weight != this.weight)
			return this.idx - o.idx;
		return o.height - this.height;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Student> stud = new ArrayList<Student>();
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			int height = Integer.parseInt(split[0]);
			int weight = Integer.parseInt(split[1]);
			stud.add(new Student(i + 1, height, weight));
		}

		Collections.sort(stud);

		for (Student st : stud) {
			System.out.println(st.height + " " + st.weight + " " + st.idx);
		}

	}

}
