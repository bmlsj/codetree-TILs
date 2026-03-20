import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		n = Integer.parseInt(split[0]);

		int sx = 0, sy = 0;
		for (int i = 0; i < n; i++) {
			split = br.readLine().split(" ");
			int dir = Integer.parseInt(split[1]);

			switch (split[0]) {
			case "N": {
				sy += dir;
				break;
			}
			case "E": {
				sx += dir;
				break;
			}
			case "S": {
				sy -= dir;
				break;
			}
			case "W": {
				sx -= dir;
				break;
			}
			}
		}

		System.out.println(sx + " " + sy);

	}

}
