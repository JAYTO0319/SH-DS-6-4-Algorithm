import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.addFirst(1);
		boolean[] visited=new boolean[n+1];
		int cnt = 0;
		visited[1] =true;
		while (!q.isEmpty()) {
			int cur = q.removeLast();
			cnt++;
			for (int v : graph[cur]) {
				if (!visited[v]) {
					visited[v]=true;
					q.addFirst(v);
				}
			}
		}
		System.out.println(cnt-1);
	}

}
