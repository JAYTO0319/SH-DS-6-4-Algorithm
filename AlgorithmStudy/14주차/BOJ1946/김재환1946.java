import java.io.*;
import java.util.*;

/*
BOJ 1946 - 신입 사원

문제 요약:
  각 지원자는 (서류 순위, 면접 순위)를 가진다.
  어떤 지원자 X가 다른 지원자 Y보다 서류도 좋고 면접도 좋으면(Y가 둘 다 더 나쁘면) Y는 선발 불가.
  최대 선발 인원을 구한다.

그리디 전략:
  1) 서류 순위 오름차순으로 정렬
  2) 앞에서부터 보며 '지금까지의 면접 최솟값(가장 좋은 면접 순위)'를 유지
  3) 현재 면접 순위가 최솟값보다 더 좋으면 선발 + 최솟값 갱신

왜 정답인가?
  서류 오름차순으로 보면,
    현재 지원자보다 서류가 더 좋은 지원자는 항상 앞에만 있다.
  현재 지원자를 떨어뜨릴 수 있는 건 "앞쪽 지원자"뿐이다.
  앞쪽 지원자 중 면접까지 더 좋은 사람이 하나라도 있으면 현재는 지배당해 탈락.
  따라서 앞쪽 면접의 최솟값만 보면 된다.
*/

public class Main {

    static class Pair {
        int doc, interview;
        Pair(int d, int i) { doc = d; interview = i; }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());
            Pair[] arr = new Pair[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int itv = Integer.parseInt(st.nextToken());
                arr[i] = new Pair(d, itv);
            }

            // 1) 서류 순위 오름차순 정렬
            Arrays.sort(arr, Comparator.comparingInt(p -> p.doc));

            // 2) 첫 사람은 무조건 선발
            int count = 1;
            int bestInterview = arr[0].interview;

            // 3) 이후 사람들을 순회하며 선발 여부 결정
            for (int i = 1; i < n; i++) {
                int interview = arr[i].interview;

                // 면접 순위가 지금까지의 최솟값보다 더 좋으면 선발
                if (interview < bestInterview) {
                    count++;
                    bestInterview = interview;
                }
                // 그렇지 않으면 앞에 (서류 더 좋고, 면접도 더 좋은) 사람이 존재 -> 탈락
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb.toString());
    }
}
