import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];

        // 상담 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i일부터 최대 수익
        int[] dp = new int[N+2];

        // 뒤에서 앞으로 채우기
        for (int i = N; i >= 1; i--) {
            int finish = i + T[i]; 

            // 상담이 퇴사 날짜 안에 끝나면
            if (finish <= N + 1) {
                // 상담을 한다 vs 안 한다
                dp[i] = Math.max(P[i] + dp[finish], dp[i+1]);
            } else {
                // 기간 넘으면 불가능
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}
