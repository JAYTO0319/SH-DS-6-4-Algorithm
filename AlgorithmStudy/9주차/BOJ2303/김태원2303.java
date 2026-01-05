import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int mxIdx, mx = 0, curIdx;
	static int [] arr = new int[5], select = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			curIdx = i;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) arr[j] = Integer.parseInt(st.nextToken());
			game(0, 0);
		}
		System.out.println(mxIdx);
	}

	private static void game(int d, int start) {
		if (d == 3) {
			//선택한 3개 숫자 다 더하고 일의자리 구하고 최댓값 구하기
			int result = 0;
			for (int i = 0; i < 3; i++) {
				result += select[i];
			}
			result %= 10;
			if (mx <= result) {
				mx = result;
				mxIdx = curIdx;
			}
			return;
		}
		for (int i = start; i < 5; i++) {
			select[d] = arr[i];
			game(d + 1, i + 1);
		}
	}

}
