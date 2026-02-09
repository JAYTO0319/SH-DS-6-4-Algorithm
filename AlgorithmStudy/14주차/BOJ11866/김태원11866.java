import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++)
			q.addFirst(i);
		int c = 1;
		while (!q.isEmpty()) {
			if (c != k) {
				c++;
				int i = q.removeLast();
				q.addFirst(i);
			}
			else {
				sb.append(q.removeLast()).append(", ");
				c = 1;
			}
		}
		sb.replace(sb.length() - 2, sb.length(), ">");
		System.out.println(sb);
	}

}
