import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int co=0; co<T; co++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+2];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			if(N > 2) {
				for(int i=3; i<=N; i++) {
					dp[i] = dp[i-3] + dp[i-2];
				}
				sb.append(dp[N]).append("\n");
			} else {
				sb.append(dp[N]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
