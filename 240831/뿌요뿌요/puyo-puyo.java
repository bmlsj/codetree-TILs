import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited = new int[n][n];
        int pump = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    dfs(i, j, map[i][j]);
                    if (cnt >= 4) pump++;
                    ans = Math.max(ans, cnt);
                }
            }

        }

        System.out.println(pump + " " + ans);

    }

    static int n, m;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;


    public static void dfs(int x, int y, int k) {

        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (visited[nx][ny] == 0 && map[nx][ny] == k) {
                visited[nx][ny] = visited[x][y] + 1;
                dfs(nx, ny, k);
            }
        }

    }
}