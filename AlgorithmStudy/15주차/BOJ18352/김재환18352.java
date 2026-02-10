import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 그래프 인접 리스트
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        // 거리 배열 초기화 (-1 = 미방문)
        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }
        dist[X] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (int city : result) {
                sb.append(city).append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}
