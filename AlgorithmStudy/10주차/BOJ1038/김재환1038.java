import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> decList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // 감소하는 수를 백트래킹으로 생성
        for (int d = 0; d < 10; d++) {
            backtrack(d, d);
        }

        Collections.sort(decList);

        if (N >= decList.size()) {
            System.out.println(-1);
        } else {
            System.out.println(decList.get(N));
        }
    }

    static void backtrack(long num, int last) {
        decList.add(num);

        for (int nxt = 0; nxt < last; nxt++) {
            backtrack(num * 10 + nxt, nxt);
        }
    }
}
