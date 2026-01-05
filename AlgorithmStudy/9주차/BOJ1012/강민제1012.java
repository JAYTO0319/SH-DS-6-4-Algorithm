public class Main1012 {
	
	static class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[M][N];
			while(K-->0) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
			}
			
			int nx=0, ny=0;
			int[] dx = {1,-1,0,0};
			int[] dy = {0,0,1,-1};
			
			Queue<Point> q = new LinkedList<>();
			boolean[][] visited = new boolean[M][N];
			int c = 0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]==1) {
						q.add(new Point(i, j));
						visited[i][j] = true;
						while(!q.isEmpty()) {
							Point now = q.poll();
							
							for(int k=0;k<4;k++) {
								nx = now.x + dx[k];
								ny = now.y + dy[k];
							
								if(nx>=0 && ny>=0 && nx<M && ny<N) {
									if(!visited[nx][ny] && map[nx][ny]==1) {
										visited[nx][ny] = true;
										q.add(new Point(nx,ny));
									}
								}
							}
						}
						c++;
					}
				}
			}
			sb.append(c+"\n");
		}
		System.out.println(sb);
	}
}

/*public class Main1012 {
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> list;
	static int c=0;
	
	static class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		if(map[x][y]==1 && !visited[x][y]) {
			q.add(new Point(x,y));
			visited[x][y] = true;
			
			int[] dx = {1,-1,0,0};
			int[] dy = {0,0,1,-1};
			
			while(!q.isEmpty()) {
				Point now = q.poll();
				
				for(int i=0;i<4;i++) {
					
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(nx>=0 && ny>=0 && nx<M && ny<N) {
						if(!visited[nx][ny] && map[nx][ny]==1) {
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					}
				}
			}
			c++;
		} 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			list = new ArrayList<>();

			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a][b]++;
				list.add(new Point(a,b));
			}
			for(Point p:list) {
				bfs(p.x, p.y);
			}
			sb.append(c+"\n");
			c=0;
		}
		System.out.println(sb);
	}
}*/
