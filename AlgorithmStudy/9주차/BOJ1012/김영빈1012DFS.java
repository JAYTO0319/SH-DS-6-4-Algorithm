import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012DFS {
	
	static int N;
	static int M;
	static int K;
	static int[][] bch;
	static boolean[][] visited;
	
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			bch = new int[N][M];
			while(K-->0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				bch[y][x] = 1;
			}
			
			visited = new boolean[N][M];
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(bch[i][j]==1 && !visited[i][j]) {
						search(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void search(int i, int j) {
		visited[i][j] = true;
		
		for(int x=0; x<4; x++) {
			int ni = i + di[x];
			int nj = j + dj[x];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>M-1) continue;
			
			if(bch[ni][nj]==1 && !visited[ni][nj]) {
				visited[ni][nj] = true;
				search(ni,nj);
			}
		}
	}
}
