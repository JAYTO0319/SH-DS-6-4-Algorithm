import java.io.*;
import java.util.*;

/*
BOJ 7983 - 내일 할거야

문제 핵심 요약:
  - 과제 N개
  - 각 과제는 d일 동안 연속 수행
  - t일까지 끝내야 함
  - 하루에 하나만 가능
  - 내일부터 연속으로 최대 며칠 쉴 수 있는지 출력

--------------------------------------------------


"쉬는 날 수"를 직접 세지 않는다.

대신 이렇게 생각한다:
  첫 과제를 가능한 한 늦게 시작하자.

첫 과제를 S일에 시작하면
  1일 ~ (S-1)일까지는 전부 쉰다.

따라서 문제는:
  "모든 과제를 마감 안에 끝낼 수 있는
   가장 늦은 첫 시작일을 구하라"
로 바뀐다.

--------------------------------------------------
그리디 전략

왜 과제를 뒤에서부터 배치하는가?

- 과제를 일찍 시작할 이유는 없다.
- 마감일만 지키면, 늦게 시작할수록 이득이다.
- 따라서 각 과제를
    '마감일에 최대한 붙여서'
    뒤에서부터 배치하는 것이 항상 최적이다.

구현 전략:
  1) 마감일 기준 오름차순 정렬
  2) 가장 마감이 늦은 과제부터
  3) 가능한 가장 늦은 시점에 붙이기
*/

public class Main {

    static class Job {
        long t; // 마감일
        long d; // 소요 기간
        Job(long t, long d) {
            this.t = t;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            jobs[i] = new Job(t, d);
        }

        // 마감일 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingLong(j -> j.t));

        // time의 의미:
        //   지금까지 배치한 과제들 앞에
        //   새 과제를 붙일 수 있는
        //   가장 늦은 종료 시점
        long time = (long)1e18;

        // 뒤에서부터 과제를 배치
        for (int i = n - 1; i >= 0; i--) {

            // 이 과제는 t일까지 끝내야 하고,
            // 이미 뒤쪽 과제들이 있으므로
            // 종료 시점은 min(time, t)
            time = Math.min(time, jobs[i].t);

            // 연속 d일 수행 → 시작 시점은 time - d
            time -= jobs[i].d;
        }

        // time = 첫 과제 시작일
        // 이 문제에서는 이것이 곧 정답
        System.out.println(time);
    }
}
