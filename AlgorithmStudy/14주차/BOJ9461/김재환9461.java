import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 문제에서 n이 최대 1,000,000까지 들어올 수 있기 때문에
        // dp 배열도 충분히 크게 잡는다.
        int MAX = 1000000;
        long[] dp = new long[MAX + 1];

        // 초기값들
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        // 점화식
        // dp[i] = dp[i-2] + dp[i-3]
        for (int i = 6; i <= MAX; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        // 이제 입력을 처리
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
