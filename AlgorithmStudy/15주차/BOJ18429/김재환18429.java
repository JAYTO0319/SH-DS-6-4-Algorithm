import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, ans;
    static int[] kits;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kits = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(ans);
    }

    static void dfs(int day, int weight) {
        // 중량이 500 미만이면 더 이상 진행 X
        if (weight < 500) return;

        // N일 모두 성공적으로 채움
        if (day == N) {
            ans++;
            return;
        }

        // 순열 생성
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                int next = weight - K + kits[i];
                dfs(day + 1, next);
                used[i] = false;
            }
        }
    }
}
