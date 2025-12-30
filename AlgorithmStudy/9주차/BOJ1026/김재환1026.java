import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] A = new int[N];
        int[] B = new int[N];

        // A 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        // B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        // 핵심 그리디:
        // A는 오름차순(작은 것부터), B는 내림차순(큰 것부터)로 맞춰 곱하면
        // Σ A[i]*B[i] 가 최소가 된다.
        Arrays.sort(A);
        Arrays.sort(B);

        long ans = 0;

        // B는 오름차순으로 정렬되어 있으니,
        // 인덱스를 뒤에서부터 읽으면 "내림차순으로 순회"하는 효과가 된다.
        // 즉, B[N-1] (가장 큰 값)과 A[0] (가장 작은 값)을 매칭.
        for (int i = 0; i < N; i++) {
            ans += (long) A[i] * (long) B[N - 1 - i];
        }

        System.out.println(ans);
    }
}
