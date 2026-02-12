import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1890 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] count = new long[N][N];
		count[0][0] = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int jump = board[i][j];
				
				if(i==N-1 && j==N-1) break;
				
				if(j+jump < N) count[i][j+jump] += count[i][j];
				
				if(i+jump < N) count[i+jump][j] += count[i][j];
			}
		}
		
		System.out.println(count[N-1][N-1]);
	}

}
