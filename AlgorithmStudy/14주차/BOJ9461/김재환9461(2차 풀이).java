import java.io.*;
//아니
//사실 n ≤ 100 이라서 1,000,000 필요 없음

//초기값도 dp[1]=dp[2]=dp[3]=1이면 끝

//문제 조건 좀ㅁ 꼼꼼히 읽을걸
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }
}
