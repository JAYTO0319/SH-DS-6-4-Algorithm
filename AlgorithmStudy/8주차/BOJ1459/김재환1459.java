import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        // 1) 직선 이동만
        long case1 = (X + Y) * W;

        // 2) 대각선 최대 활용
        long case2;
        if ((X + Y) % 2 == 0) {
            case2 = Math.max(X, Y) * S;
        } else {
            case2 = (Math.max(X, Y) - 1) * S + W;
        }

        // 3) 대각선 일부 + 직선
        long case3 = Math.min(X, Y) * S + Math.abs(X - Y) * W;

        long ans = Math.min(case1, Math.min(case2, case3));
        System.out.println(ans);
    }
}
