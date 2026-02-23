import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int left = 0, right = 0;
        int ans = 0;

        while (right < N) {
            if (cnt[arr[right]] < K) {
                cnt[arr[right]]++;
                right++;
                ans = Math.max(ans, right - left);
            } else {
                cnt[arr[left]]--;
                left++;
            }
        }
        System.out.println(ans);
    }
}
