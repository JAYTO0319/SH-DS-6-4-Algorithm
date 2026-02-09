import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
BOJ 1890 - 점프

dp[r][c] : (r,c)까지 올 수 있는 경우의 수

점화식:
  dp[r][c] 가 누적된 경로라면
  점프 숫자 k = board[r][c] 만큼
    오른쪽: dp[r][c+k] += dp[r][c]
    아래쪽: dp[r+k][c] += dp[r][c]

dp 시작은 dp[0][0] = 1
끝 결과는 dp[n-1][n-1]
*/

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N][N];
        int[][] board = new int[N][N];

        // 입력 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작점은 한 가지 경로로 시작
        dp[0][0] = 1L;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                long ways = dp[r][c];
                if (ways == 0) {
                    // 해당 칸에 올 방법이 없다면 skip
                    continue;
                }

                int jump = board[r][c];
                if (jump == 0) {
                    // 값이 0이면 이동 불가
                    continue;
                }

                // 오른쪽
                if (c + jump < N) {
                    dp[r][c + jump] += ways;
                }

                // 아래쪽
                if (r + jump < N) {
                    dp[r + jump][c] += ways;
                }
            }
        }

        // (N-1, N-1)에 누적된 경로 수 출력
        System.out.println(dp[N-1][N-1]);
    }
}
