import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int n, m;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);

		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		dfs(0, 0);
//		for (boolean[] v : visited) {
//			System.out.println(Arrays.toString(v));
//		}
		System.out.println(ans == false ? 0 : 1);
	}

	private static int[] dx = { 0, 1 };
	private static int[] dy = { 1, 0 };
	private static boolean ans = false;

	public static void dfs(int x, int y) {

		visited[x][y] = true;
		if (x == n - 1 && y == m - 1) {
			ans = true;
			return;
		}

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}

	}

}