import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static boolean graph[][];
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new boolean[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = true;
			graph[v][u] = true;
		}
		bfs(f, s);
	}

	private static void bfs(int f, int s) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean visited[] = new boolean[n + 1];
		q.addFirst(new int[] {f, 0});
		visited[f] = true;
		while(!q.isEmpty()) {
			int[] cur = q.removeLast();
			int u = cur[0];
			int cost = cur[1];
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[u][i]) {
					if (i == s) {
						System.out.println(cost + 1);
						return;
					}
					visited[i] = true;
					q.addFirst(new int[] {i, cost + 1});
				}
			}
		}
		System.out.println(-1);
	}
	
}
