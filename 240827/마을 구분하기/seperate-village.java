import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	private static int n;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					int tmp = dfs(i, j);
					ans.add(tmp);
				}

			}
		}
//		for (boolean[] v : visited) {
//			System.out.println(Arrays.toString(v));
//		}
		Collections.sort(ans);
		System.out.println(ans.size());

        for(int n: ans) {
            System.out.println(n);
        }
	
	}

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	static List<Integer> ans = new ArrayList<>();

	public static int dfs(int x, int y) {

		visited[x][y] = true;
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				cnt += dfs(nx, ny);
			}
		}

		return cnt;
	}

}