import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][3];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = i;
			}
			Arrays.sort(arr, (a, b)-> {return a[0] - b[0];});
			int prev = arr[0][1];
			int count = 1;
			for (int i = 1; i < n; i++) {
				if (prev > arr[i][1]) {
					prev = arr[i][1];
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
