import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		ArrayDeque<int[]> tomato = new ArrayDeque<>();
		int tcnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					tcnt++;
					tomato.addFirst(new int[] {i, j, 0});
				}
                if (map[i][j] == 0) tcnt++;
			}
		}
		if (tcnt == 0) {
			System.out.println(0);
			return;
		}
		int answer = 0;
		int [] di = {0,0,1,-1};
		int [] dj = {1,-1,0,0};
		while (!tomato.isEmpty()) {
			int[] cur = tomato.removeLast();
			for (int dir = 0; dir < 4; dir++) {
				int ni = cur[0] + di[dir];
				int nj = cur[1] + dj[dir];
				if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
				if (map[ni][nj] == 0) {
					map[ni][nj] = 1;
					tomato.addFirst(new int[] {ni, nj, cur[2] + 1});
					answer = cur[2] + 1;
				}
				
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}

}
