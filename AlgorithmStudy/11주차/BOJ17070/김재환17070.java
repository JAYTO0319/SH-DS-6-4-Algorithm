import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        board = new int[N][N];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치는 파이프가 (0,0)-(0,1)에 놓여 있으므로
        // 끝 좌표 (0,1)과 방향(가로=0)부터 탐색 시작
        dfs(0, 1, 0);

        // 최종 경우의 수 출력
        System.out.println(answer);
    }

    /**
     * @param r 현재 파이프 오른쪽 끝의 행
     * @param c 현재 파이프 오른쪽 끝의 열
     * @param dir 현재 파이프 방향
     *            0 = 가로, 1 = 세로, 2 = 대각선
     */
    static void dfs(int r, int c, int dir) {

        // 도착지점(N-1, N-1)에 도달하면 경우 수 증가
        if (r == N - 1 && c == N - 1) {
            answer++;
            return;
        }

        // 1) 가로 방향일 때
        if (dir == 0) {
            // → 가로로 이동 가능?
            int nr = r, nc = c + 1;
            if (nc < N && board[nr][nc] == 0) {
                dfs(nr, nc, 0);
            }
            // ↘ 대각선 이동
            nr = r + 1; nc = c + 1;
            if (nr < N && nc < N
                    && board[r][c + 1] == 0
                    && board[r + 1][c] == 0
                    && board[nr][nc] == 0) {
                dfs(nr, nc, 2);
            }
        }

        // 2) 세로 방향일 때
        if (dir == 1) {
            // ↓ 세로로 이동 가능?
            int nr = r + 1, nc = c;
            if (nr < N && board[nr][nc] == 0) {
                dfs(nr, nc, 1);
            }
            // ↘ 대각선 이동
            nr = r + 1; nc = c + 1;
            if (nr < N && nc < N
                    && board[r][c + 1] == 0
                    && board[r + 1][c] == 0
                    && board[nr][nc] == 0) {
                dfs(nr, nc, 2);
            }
        }

        // 3) 대각선 방향일 때
        if (dir == 2) {
            // → 가로 이동
            int nr = r, nc = c + 1;
            if (nc < N && board[nr][nc] == 0) {
                dfs(nr, nc, 0);
            }
            // ↓ 세로 이동
            nr = r + 1; nc = c;
            if (nr < N && board[nr][nc] == 0) {
                dfs(nr, nc, 1);
            }
            // ↘ 대각선 이동
            nr = r + 1; nc = c + 1;
            if (nr < N && nc < N
                    && board[r][c + 1] == 0
                    && board[r + 1][c] == 0
                    && board[nr][nc] == 0) {
                dfs(nr, nc, 2);
            }
        }
    }
}
