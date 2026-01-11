import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] a, b;
		while (t-->0) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			a = new int[n];
			b = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(a);Arrays.sort(b);
			for (int i = 0; i < n; i++) {
				if (a[i] < b[0]) continue;
				if (a[i] > b[m - 1]) {
					answer += m;
					continue;
				}
				// 이진 탐색 lower bound search
				int l = 0, r = m;
				while (l < r) {
					int mid = (l + r) / 2;
					if (b[mid] >= a[i]) r = mid;
					else l = mid + 1;
				}
				answer += l;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
