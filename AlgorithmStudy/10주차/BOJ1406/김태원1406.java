import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String iniWord = br.readLine();
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int l = iniWord.length();
		ArrayDeque<Character> lq = new ArrayDeque();
		ArrayDeque<Character> rq = new ArrayDeque();
		for (int i = 0; i < l; i++) {
			lq.addLast(iniWord.charAt(i));
		}
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			char comm = st.nextToken().charAt(0);
			if (comm == 'L') {
				if (lq.isEmpty()) continue;
				rq.addFirst(lq.removeLast());
			} else if (comm == 'D') {
				if (rq.isEmpty()) continue;
				lq.addLast(rq.removeFirst());
			} else if (comm == 'B') {
				if (lq.isEmpty()) continue;
				lq.removeLast();
			} else {
				lq.addLast(st.nextToken().charAt(0));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!lq.isEmpty()) {
			sb.append(lq.removeFirst());
		}
		while (!rq.isEmpty()) {
			sb.append(rq.removeFirst());
		}
		System.out.println(sb);
	}

}
