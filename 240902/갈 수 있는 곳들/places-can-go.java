import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]); // start
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		visited = new boolean[n][n];
		int ans = 0;
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int r = Integer.parseInt(split[0]) - 1;
			int c = Integer.parseInt(split[0]) - 1;

			if (!visited[r][c]) {
				cnt = 1;
				bfs(r, c);

				ans += cnt;
			}

		}

		System.out.println(ans);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cnt;

	private static void bfs(int r, int c) {
		// TODO Auto-generated method stub

		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];

			visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}

				if (!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					cnt++;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
	}

}