import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: N, K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Queue를 이용해서 사람들을 저장
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 n까지 Queue에 넣는다
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // Queue가 비워질 때까지 반복
        while (!queue.isEmpty()) {

            // K-1명은 앞에서 뽑아서 뒤로 넣는다
            for (int i = 1; i < k; i++) {
                int x = queue.poll(); // 맨 앞 사람 제거
                queue.add(x);         // 뒤로 넣음
            }

            // k번째 사람을 제거해서 결과에 추가
            sb.append(queue.poll()).append(", ");
        }

        // "1, 2, 3, " 이런 형식으로 끝나기 때문에
        // 마지막 쉼표를 제거하고 닫는 괄호 붙이기
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
