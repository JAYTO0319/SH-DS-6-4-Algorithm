import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열
        String initial = br.readLine();

        // 왼쪽/오른쪽 덱
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        // 초기 문자열의 문자들을 left에 삽입
        for (char c : initial.toCharArray()) {
            left.addLast(c);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("L")) {
                if (!left.isEmpty()) {
                    right.addLast(left.removeLast());
                }
            } else if (cmd.equals("D")) {
                if (!right.isEmpty()) {
                    left.addLast(right.removeLast());
                }
            } else if (cmd.equals("B")) {
                if (!left.isEmpty()) {
                    left.removeLast();
                }
            } else if (cmd.equals("P")) {
                char x = st.nextToken().charAt(0);
                left.addLast(x);
            }
        }

        // left에는 앞쪽 순서, right에는 뒤집힌 커서 오른쪽
        StringBuilder sb = new StringBuilder();

        for (char c : left) {
            sb.append(c);
        }

        // right는 뒤집어서 붙임
        while (!right.isEmpty()) {
            sb.append(right.removeLast());
        }

        System.out.print(sb.toString());
    }
}
