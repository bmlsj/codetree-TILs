
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		map = new int[n][m];

		int num = 1;
		int x = 0, y = 0;
		int dir = 0;
		map[0][0] = num;

		while (num < n * m) {

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] > 0) {
				dir = (dir + 1) % 4;
				continue;
			}
			if (map[nx][ny] == 0) {
				map[nx][ny] = ++num;
			}

			x = nx;
			y = ny;
		}

		for (int[] ma : map) {
			for(int mm: ma) {
				System.out.print(mm + " ");
			}
			System.out.println();
		}
	}
	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

}
