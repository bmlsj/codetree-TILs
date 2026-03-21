import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair> {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}

public class Main {

	static int[][] map;
	static int n, k;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		input = br.readLine().split(" ");
		int sx = Integer.parseInt(input[0]) - 1;
		int sy = Integer.parseInt(input[1]) - 1;

		while (k-- > 0) {
			Pair next = bfs(sx, sy);

			if (next.x == sx && next.y == sy)
				break;

			sx = next.x;
			sy = next.y;
		}
		System.out.println((sx + 1) + " " + (1 + sy));

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static Pair bfs(int x, int y) {

		Queue<Pair> queue = new ArrayDeque<Pair>();
		queue.offer(new Pair(x, y));

		boolean[][] visited = new boolean[n][n];
		visited[x][y] = true;

		int current = map[x][y];
		int maxVal = -1;
		List<Pair> candidates = new ArrayList<>();

		while (!queue.isEmpty()) {

			Pair curr = queue.poll();

			x = curr.x;
			y = curr.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (!visited[nx][ny] && map[nx][ny] < current) {

					visited[nx][ny] = true;
					queue.offer(new Pair(nx, ny));

					if (map[nx][ny] > maxVal) {
						maxVal = map[nx][ny];
						candidates.clear();
						candidates.add(new Pair(nx, ny));
					} else if (map[nx][ny] == maxVal) {
						candidates.add(new Pair(nx, ny));
					}
				}
			}

		}

		if (candidates.isEmpty())
			return new Pair(x, y);

		Collections.sort(candidates);
		return candidates.get(0);

	}

}
