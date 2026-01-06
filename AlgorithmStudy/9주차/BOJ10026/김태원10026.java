import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static char[][] map;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int no = bfs(false);
		int yes = bfs(true);
		System.out.println(no + " " + yes);
	}

	static int bfs(boolean isRG) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		int cnt = 0;
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					cnt++;
					char start = map[i][j];
					q.addFirst(new int[] {i, j});
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] cur = q.removeLast();
						for (int dir = 0; dir < 4; dir++) {
							int ni = cur[0] + di[dir];
							int nj = cur[1] + dj[dir];
							if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
							if (visited[ni][nj]) continue;
							if (isRG && (start == 'R' || start == 'G') && (map[ni][nj] == 'R' || map[ni][nj] == 'G')) {
								visited[ni][nj] = true;
								q.addFirst(new int[] {ni, nj});
								continue;
							}
							if (map[ni][nj] == start) {
								visited[ni][nj] = true;
								q.addFirst(new int[] {ni, nj});
							}
						}
					}
				}
			}
		}
		return cnt;
	}
	
}
