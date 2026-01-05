import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<int[]> cabb = new ArrayList<>();
		ArrayDeque<int[]> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		while (t-->0) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
				cabb.add(new int[] {y, x});
			}
			for (int[] c : cabb) {
				if (map[c[0]][c[1]] == 1) {
					answer++;
					map[c[0]][c[1]] = 0;
					q.addFirst(c);
					while (!q.isEmpty()) {
						int [] cur = q.removeLast();
						for (int dir = 0; dir < 4; dir++) {
							int ni = cur[0] + di[dir];
							int nj = cur[1] + dj[dir];
							if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
							if (map[ni][nj] == 0) continue;
							map[ni][nj] = 0;
							q.addFirst(new int[] {ni, nj});
						}
					}
				}
			}
            cabb.clear();
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
