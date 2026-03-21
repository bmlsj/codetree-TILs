import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {

	static int[][] map;
	static int n, k, m;
	static int[][] visited;
	static int answer = -1;
	static List<Pair> startPoints;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		m = Integer.parseInt(input[2]);

		map = new int[n][n];
		List<Pair> stones = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 1) {
					stones.add(new Pair(i, j));
				}
			}
		}

		startPoints = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]) - 1;
			int c = Integer.parseInt(input[1]) - 1;

			startPoints.add(new Pair(r, c));
		}

		combinations(stones, 0, m, 0);

		System.out.println(answer);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void combinations(List<Pair> stones, int start, int M, int depth) {
		if (M == depth) {

			visited = new int[n][n];
			bfs(startPoints);

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] > 0)
						count++;
				}
			}

			answer = Math.max(answer, count);

			return;
		}

		for (int i = start; i < stones.size(); i++) {
			Pair pair = stones.get(i);
			map[pair.x][pair.y] = 0;
			combinations(stones, i + 1, M, depth + 1);
			map[pair.x][pair.y] = 1;

		}
	}

	static void bfs(List<Pair> startPoints) {

		Queue<Pair> queue = new ArrayDeque<>();
		for (Pair start : startPoints) {
			queue.offer(start);
			visited[start.x][start.y] = 1;
		}

		while (!queue.isEmpty()) {

			Pair curr = queue.poll();

			int x = curr.x;
			int y = curr.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (visited[nx][ny] == 0 && map[nx][ny] == 0) {

					visited[nx][ny] = visited[x][y] + 1;
					queue.offer(new Pair(nx, ny));

				}
			}

		}

	}

}
