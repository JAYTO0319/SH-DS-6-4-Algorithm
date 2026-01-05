public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0;i<N;list[i++] = new ArrayList<>());
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j)=='Y') {
					list[i].add(j);
				}
			}
		}
		int[] arr = new int[N];
		
		int max = 0;
		for(int i=0;i<N;i++) {
			int[] dist = new int[N];
			boolean[] visited = new boolean[N];
			Queue<Integer> q = new ArrayDeque<>();
			q.add(i);
			visited[i] = true;
			int c=0;
			while(!q.isEmpty()) {
				int now = q.poll();
				if(dist[now]>=2) continue;
				for(int n:list[now]) {
					if(!visited[n]) {
						visited[n] = true;
						dist[n] = dist[now] + 1;
						c++;
						q.add(n);
					}
				}
			}
			if(max<c) max = c;
			c=0;
		}
		System.out.println(max);
	}
}
