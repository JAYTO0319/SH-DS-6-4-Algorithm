import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입출력 최적화를 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 기록 개수
        int n = Integer.parseInt(br.readLine());

        // 현재 회사에 있는 사람들의 이름을 저장할 Set
        // Set을 쓰면 enter 시 중복 없이 저장, leave 시 빠르게 삭제 가능
        HashSet<String> set = new HashSet<>();

        // n개의 로그 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 이름
            String name = st.nextToken();

            // 행동: "enter" 또는 "leave"
            String action = st.nextToken();

            // "enter"이면 Set에 저장
            if (action.equals("enter")) {
                set.add(name);
            } else {
                // "leave"이면 Set에서 제거
                // remove는 존재 여부 체크 없이 호출해도 안전
                set.remove(name);
            }
        }

        // 현재 Set 안에 남아있는 사람 이름들을 List로 옮긴다
        ArrayList<String> list = new ArrayList<>(set);

        // 사전 순 역순 정렬
        // reverseOrder()를 사용하면 내림차순 정렬이 된다
        Collections.sort(list, Collections.reverseOrder());

        // 정렬된 이름을 한 줄씩 출력
        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append('\n');
        }

        System.out.print(sb);
    }
}
