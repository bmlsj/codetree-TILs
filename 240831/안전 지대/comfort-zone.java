import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            split = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int maxArea = -1;
        int bestK = 1;

        for (int k = 1; k <= 100; k++) { 
            visited = new boolean[n][m];
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j, k);
                    }
                }
            }

            if (cnt > maxArea) {
                maxArea = cnt;
                bestK = k;
            }
        }

        System.out.println(bestK + " " + maxArea);
    }

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 1;


    public static void dfs(int x, int y, int k) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] > k) {
                visited[nx][ny] = true;
                dfs(nx, ny, k);
            }
        }
    }
}