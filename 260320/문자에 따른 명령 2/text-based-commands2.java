import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int[] ans = command(input, 0, 0);
		System.out.println(ans[0] + " " + ans[1]);

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int[] command(String comm, int sx, int sy) {

		char[] comms = comm.toCharArray();
		int dir = 0;
		int nx = sx, ny = sy;

		for (char c : comms) {

			if (c == 'L') { // 반시계
				dir = (dir + 3) % 4;
			} else if (c == 'R') {
				dir = (dir + 1) % 4;
			} else {
				nx += dx[dir];
				ny += dy[dir];
			}
		}

		return new int[] { nx, ny };
	}

}
