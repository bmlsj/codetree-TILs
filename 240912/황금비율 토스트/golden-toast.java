import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int m = Integer.parseInt(split[1]);
		
		LinkedList<String> list = new LinkedList<>();
		for (String s : in.readLine().split("")) {
			list.add(s);
		}
		
		ListIterator<String> it = list.listIterator(list.size());
		for(int i = 0; i < m;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String comments = st.nextToken();
			if (comments.equals("L")) {
				if (it.hasPrevious()) {
					it.previous();
				}
			} else if (comments.equals("R")) {
				if (it.hasNext()) {
					it.next();
				}
			} else if (comments.equals("D")) {
				it.next();
				it.remove();
			} else if (comments.equals("P")) {
				it.add(st.nextToken());
			}
		}
		
		it = list.listIterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
	}

}