import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);

		int x = 0, y = 0;
		int cnt = 0;
		boolean check = false;
		for (int i = 0; i < n; i++) {
			split = br.readLine().split(" ");
			int dirNum = 0;
			if (split[0].equals("E")) {
				dirNum = 0;
			} else if (split[0].equals("S")) {
				dirNum = 1;
			} else if (split[0].equals("W")) {
				dirNum = 2;
			} else {
				dirNum = 3;
			}

			int nx = x, ny = y;
			for (int d = 0; d < Integer.parseInt(split[1]); d++) {
				nx += dx[dirNum];
				ny += dy[dirNum];
				cnt++;
				if (nx == 0 && ny == 0) {
					System.out.println(cnt);
					check = true;
				}
			}
			x = nx;
			y = ny;

			if (check)
				break;
		}

		if (!check)
			System.out.println("-1");

	}

	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

}
