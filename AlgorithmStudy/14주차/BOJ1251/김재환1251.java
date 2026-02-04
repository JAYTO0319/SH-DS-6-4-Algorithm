import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        // 최소 사전 문자열을 저장할 변수
        String best = null;

        // i는 A의 끝 인덱스 (1부터 시작)
        for (int i = 1; i < n - 1; i++) {
            // j는 A+B의 끝 인덱스
            for (int j = i + 1; j < n; j++) {

                // A = s.substring(0, i)
                // B = s.substring(i, j)
                // C = s.substring(j, n)
                String A = s.substring(0, i);
                String B = s.substring(i, j);
                String C = s.substring(j);

                // 각 부분을 뒤집어서 저장
                String revA = new StringBuilder(A).reverse().toString();
                String revB = new StringBuilder(B).reverse().toString();
                String revC = new StringBuilder(C).reverse().toString();

                // 세 부분을 이어붙인다.
                String combined = revA + revB + revC;

                // 최소값 갱신
                if (best == null || combined.compareTo(best) < 0) {
                    best = combined;
                }
            }
        }

        // 결과 출력
        System.out.println(best);
    }
}
