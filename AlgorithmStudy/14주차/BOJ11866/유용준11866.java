import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// queue를 사용해서 다시 풀기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Deque<Integer> deq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			deq.add(i);
		}
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!deq.isEmpty()) {
			count++;
			if (count == k) {
				sb.append(deq.pollFirst());
				if (deq.isEmpty()) {
					sb.append(">");
				} else {
					sb.append(", ");
				}
				count = 0;
			} else {
				deq.addLast(deq.pollFirst());
			}
		}
		System.out.println(sb);
	}

}
