import java.io.*;
import java.util.*;
    // 왜 きたまさ法를 생각못했지? 배운 걸 이렇게까지 못써먹을 수 있나....
public class Main {

    // 점화식 차수 (P(n) = P(n-2) + P(n-3))
    static final int K = 3;

    // P(1), P(2), P(3)
    static final long[] init = {1, 1, 1};

    // f[n] = 0*f[n-1] + 1*f[n-2] + 1*f[n-3]
    static final long[] c = {0, 1, 1};

    // 다항식 곱한 뒤 점화식으로 차수 줄이기
    static long[] mul(long[] a, long[] b) {
        long[] tmp = new long[2 * K - 1];

        // 그냥 컨볼루션
        for (int i = 0; i < K; i++)
            for (int j = 0; j < K; j++)
                tmp[i + j] += a[i] * b[j];

        // x^K 이상은 점화식으로 접어넣기
        for (int i = 2 * K - 2; i >= K; i--) {
            long v = tmp[i];
            if (v == 0) continue;
            for (int t = 0; t < K; t++)
                tmp[i - 1 - t] += v * c[t];
        }

        return Arrays.copyOf(tmp, K);
    }

    // x^n 을 점화식 기준으로 표현
    static long[] powX(long n) {
        long[] res = new long[K];
        long[] base = new long[K];

        res[0] = 1;   // x^0
        base[1] = 1;  // x

        // 그냥 이진 거듭제곱
        while (n > 0) {
            if ((n & 1) == 1) res = mul(res, base);
            base = mul(base, base);
            n >>= 1;
        }
        return res;
    }

    // 이제 n번째 값은 초기값 조합으로 바로
    static long P(long n) {
        long idx = n - 1; // 인덱스 맞추기
        if (idx < 3) return init[(int) idx];

        long[] coef = powX(idx);

        long ans = 0;
        for (int i = 0; i < K; i++)
            ans += coef[i] * init[i];

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(P(Long.parseLong(br.readLine()))).append('\n');
        }
        System.out.print(sb);
    }
}
