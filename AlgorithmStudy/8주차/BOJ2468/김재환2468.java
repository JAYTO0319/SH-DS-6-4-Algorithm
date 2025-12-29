import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > maxHeight) {
                    maxHeight = board[i][j];
                }
            }
        }

        int answer = 0;

        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] > h) {
                        dfs(i, j, h);
                        cnt++;
                    }
                }
            }
            if (cnt > answer) {
                answer = cnt;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int h) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0], cy = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && board[nx][ny] > h) {
                        visited[nx][ny] = true;
                        stack.push(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
