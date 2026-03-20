
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int t = Integer.parseInt(split[1]);

		// map = new int[n][n];

		split = br.readLine().split(" ");
		int r = Integer.parseInt(split[0]);
		int c = Integer.parseInt(split[1]);
		int dir = makeDir(split[2].charAt(0));

		while (t > 0) {
			t--;

			int nx = r + dx[dir];
			int ny = c + dy[dir];

			if (nx < 1 || ny < 1 || nx >= n || ny >= n) {
				dir = 3 - dir;
				continue;
			}
			r = nx;
			c = ny;
		}

		System.out.println((r) + " " + (c));

	}

	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	static int makeDir(char dir) {

		int dirNum = 0;
		if (dir == 'R')
			dirNum = 0;
		else if (dir == 'D')
			dirNum = 1;
		else if (dir == 'U')
			dirNum = 2;
		else if (dir == 'L')
			dirNum = 3;

		return dirNum;
	}

}
