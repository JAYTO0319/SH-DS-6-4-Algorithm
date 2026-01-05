import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String[] friends = new String[N];

        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().trim();
        }

        int max2Friends = 0;

        for (int i = 0; i < N; i++) {
            int[] dist = new int[N];
            Arrays.fill(dist, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            dist[i] = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (dist[cur] == 2) continue;

                // 인접 친구 탐색
                for (int j = 0; j < N; j++) {
                    if (friends[cur].charAt(j) == 'Y' && dist[j] == -1) {
                        dist[j] = dist[cur] + 1;
                        queue.add(j);
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                if (j != i && dist[j] != -1 && dist[j] <= 2) {
                    count++;
                }
            }
            max2Friends = Math.max(max2Friends, count);
        }

        System.out.println(max2Friends);
    }
}
