import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int s = Integer.parseInt(br.readLine());
		/*
		 * 앞에서부터 s 범위 안에서 가장 큰 애를 찾아서 앞으로 가져옴 교환 카운트해서 s에서 빼줌 s가 아직 0보다 크면 맨 앞 빼고 다시 반복
		 */

		if (n == 1) {
			System.out.println(arr[0]);
			return;
		}

		int fin = -1;
		while (s != 0 && fin < n - 1) {
			fin++;
			// s 범위 안에서 가장 큰 수 찾기 mxIdx
			int end = fin + s >= n ? n - 1 : fin + s;
			int mxIdx = fin;
			for (int i = fin; i <= end; i++) {
				if (arr[mxIdx] < arr[i])
					mxIdx = i;
			}
			for (int i = mxIdx; i >= 1; i--) {
				if (arr[i] > arr[i - 1]) {
					int tmp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = tmp;
					s--;
					if (s == 0) break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}

}
