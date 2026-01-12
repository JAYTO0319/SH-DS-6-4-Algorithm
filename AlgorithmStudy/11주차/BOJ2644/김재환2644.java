import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 전체 사람 수
        int n = Integer.parseInt(br.readLine().trim());

        // 2. 촌수를 구할 두 사람 번호 입력
        st = new StringTokenizer(br.readLine());
        int personA = Integer.parseInt(st.nextToken()); // 시작점
        int personB = Integer.parseInt(st.nextToken()); // 목표점

        // 3. 부모 자식 관계 수
        int m = Integer.parseInt(br.readLine().trim());

        /*
         * 가족 관계를 저장할 인접 리스트 그래프
         * 각 사람 번호 최대 n까지 존재하므로
         * index 1부터 사용하기 위해 크기를 n+1로 설정
         */
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 부모-자식 관계 입력
        // 이 문제는 부모와 자식이 주어지지만,
        // 실제로는 양방향 관계(부모↔자식)이므로 둘 다 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            // 양방향 연결: p1 ↔ p2
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        // 방문 여부 및 촌수 저장 배열
        // visited[i] = i번 사람까지의 촌수
        int[] visited = new int[n + 1];

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.add(personA);       // 시작 노드 push
        visited[personA] = 1;      // 촌수 계산을 위해 1로 시작

        // 촌수 결과
        int result = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표 인물에 도달하면 종료
            if (current == personB) {
                // 실제 촌수는 visited 값 - 1
                result = visited[current] - 1;
                break;
            }

            // 인접한 모든 관계 노드 탐색
            for (int next : graph.get(current)) {
                // 아직 방문하지 않았다면
                if (visited[next] == 0) {
                    // 현재 촌수 + 1로 저장
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }

        // 출력 (연결이 없다면 result = -1 그대로)
        System.out.println(result);
    }
}
