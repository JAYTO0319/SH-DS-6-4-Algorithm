import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] stick = new int[n][2];
		StringTokenizer st;
		int mx = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			stick[i][0] = Integer.parseInt(st.nextToken());
			stick[i][1] = Integer.parseInt(st.nextToken());
			mx = Math.max(mx, stick[i][1]);
		}
		Arrays.sort(stick, (a, b) -> a[0] - b[0]);
		int curMx = 0, curMxIdx = 0;
		int answer = 0;
		// 왼쪽에서 탐색 시작. 더 높은 높이를 만나면 거기까지 넓이 더하기. 최대 높이는 그 높이랑 같은 기둥 만날때마다 더해주기
		for (int i = 0; i < n; i++) {
			if (stick[i][1] == mx || stick[i][1] > curMx) {
				//가장 최근 기둥 후부터 더 높은 기둥 전까지 구간 넓이
				answer += curMx * (stick[i][0] - curMxIdx - 1);
				//더 높은 기둥 넓이
				answer += stick[i][1];
				//최근 기둥 높이, 인덱스 갱신
				curMx = stick[i][1];
				curMxIdx = stick[i][0];
			}
		}
		// 오른쪽에서 탐색 시작. 높이가 mx인 기둥 만나기 전까지 넓이 구함
		curMx = 0; curMxIdx = 0;
		for (int i = n-1; i >= 0; i--) {
			//전체 최대 높이 만나기 전까지 넓이 구함
			if (stick[i][1] != mx && stick[i][1] > curMx) {
				answer += stick[i][1];
				answer += curMx * (curMxIdx - stick[i][0] - 1);
				curMx = stick[i][1];
				curMxIdx = stick[i][0];
			}
			//전체 최대 높이 만나면 지금까지 넓이 더하고 종료
			if (stick[i][1] == mx) {
				answer += curMx * (curMxIdx - stick[i][0] - 1);
				break;
			}
		}
		System.out.println(answer);
	}

}
