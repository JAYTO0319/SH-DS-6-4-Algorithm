import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2644 {
	
	static int n;
	static LinkedList<Integer>[] adj;
	static int[] chons;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		adj = new LinkedList[n+1];
		
		for(int i=1; i<=n; i++) {
			adj[i] = new LinkedList<>();
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		chons = new int[n+1];
		
		bfs(start,end);
		
		if(chons[end]!=0) {
			System.out.println(chons[end]-1);
		} else {
			System.out.println(-1);
		}
	}

	private static void bfs(int start, int end) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		chons[start] = 1;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int x : adj[cur]) {
				if(x == end) {
					chons[x] = chons[cur] + 1;
					return;
				}
				
				if(chons[x]==0) {
					chons[x] = chons[cur] + 1;
					queue.add(x);
				}
			}
		}
	}

}
