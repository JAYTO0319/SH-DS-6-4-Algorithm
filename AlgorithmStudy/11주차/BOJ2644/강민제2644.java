public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//dfs, 1번이 가장 윗사람
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[N+1];
		int res = -1;
		q.add(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now==y) {
				res = visited[now];
				break;
			}
			for(int n:list[now]) {
				if(visited[n]==0) {
					visited[n] = visited[now] + 1;
					q.add(n);
				}
			}
		}
		System.out.println(res);
	}
}
