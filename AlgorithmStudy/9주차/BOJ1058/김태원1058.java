import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int answer = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			//i의 친구 수를 구한다.
			boolean[] isF = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'Y') {
					cnt++;
					q.addFirst(j);
					isF[j] = true;
				}
			}
			isF[i] = true;
			//i의 친구의 친구 수를 구한다.
			while (!q.isEmpty()) {
				int cur = q.removeLast();
				for (int j = 0; j < n; j++) {
					if (map[cur][j] == 'Y' && !isF[j]) {
						cnt++;
						isF[j] = true;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

}
