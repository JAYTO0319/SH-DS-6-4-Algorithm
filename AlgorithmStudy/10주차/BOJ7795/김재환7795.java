import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // B 정렬
            Arrays.sort(B);

            long ans = 0;
            for (int a : A) {
                // 이분탐색으로 a보다 작은 B 개수를 찾는다
                int left = 0;
                int right = M;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (B[mid] < a) left = mid + 1;
                    else right = mid;
                }
                ans += left; // left는 B에서 a보다 작은 원소 개수
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
