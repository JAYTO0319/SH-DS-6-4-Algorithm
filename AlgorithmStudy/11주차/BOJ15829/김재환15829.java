import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력은 두 줄:
        // 1) L : 문자열 길이 (사실 문자열 길이로도 알 수 있지만, 문제 형식상 주어짐)
        // 2) 문자열 (소문자만)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        // 문제에서 고정으로 주는 값
        final long R = 31L;
        final long MOD = 1234567891L;

        // 해시 값 누적 변수
        long hash = 0L;

        // power는 R^i 를 의미한다.
        // i=0일 때 R^0 = 1로 시작
        long power = 1L;

        // 문자열의 i번째 문자를 a_i로 바꿔서:
        // hash = Σ (a_i * R^i) mod MOD
        //
        // 중간 값이 커질 수 있으므로 long으로 계산하고
        //       매 단계마다 mod를 적용해 overflow 위험을 줄인다.
        for (int i = 0; i < L; i++) {
            char ch = s.charAt(i);

            // a -> 1, b -> 2, ..., z -> 26
            long val = (ch - 'a' + 1);

            // (val * power) 항을 더하고 mod
            hash = (hash + (val * power) % MOD) % MOD;

            // 다음 자리(i+1)를 위해 power = power * R (즉 R^(i+1))로 갱신
            power = (power * R) % MOD;
        }

        System.out.println(hash);
    }
}
