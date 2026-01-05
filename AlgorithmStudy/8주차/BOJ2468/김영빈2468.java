import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main2468 {
	
	static int N;
	static int[][] area;
	static boolean visited[][];
	
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		area = new int[N][N];
		
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int x = Integer.parseInt(st.nextToken());
				area[i][j] = x;
				if(x>max) {
					max = x;
				}
			}
		}
		
		int maxArea = 0;
		for(int high = 0; high <= max; high++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(area[i][j]>high && !visited[i][j]) {
						bfs(i,j,high);
						cnt++;
					}
				}
			}
			if(cnt>maxArea) {
				maxArea = cnt;
			}
		}
		System.out.println(maxArea);
	}

	private static void bfs(int i, int j, int high) {
		Deque<int[]> queue = new ArrayDeque<>();
		
		visited[i][j] = true;
		queue.add(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int x=0; x<4; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
				
				if(area[ni][nj]>high && !visited[ni][nj]) {
					visited[ni][nj] = true;
					queue.add(new int[] {ni,nj});
				}
			}
		}
	}

}
