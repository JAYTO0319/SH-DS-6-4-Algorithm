import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int x, int y, boolean colorBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        char startColor = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;

                if (colorBlind) {
                    // 적록색약: R/G 동일
                    if ((startColor == 'R' || startColor == 'G') &&
                        (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                    // B는 B끼리만
                    else if (startColor == 'B' && map[nx][ny] == 'B') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                } else {
                    // 정상 시야
                    if (map[nx][ny] == startColor) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 정상 시야
        visited = new boolean[N][N];
        int normal = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    normal++;
                }
            }
        }

        // 적록색약
        visited = new boolean[N][N];
        int colorBlind = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    colorBlind++;
                }
            }
        }

        System.out.println(normal + " " + colorBlind);
    }
}
