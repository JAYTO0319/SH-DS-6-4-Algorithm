import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		/*
		 * 한블록 이동의 두 배와 대각선 이동 비용 비교
		 * 대각선 이동 비용이 더 크면 그냥 전부 블록 이동
		 * 아니면 대각선으로 쭉 가고 남은걸 블록 이동
		 * 만약 대각선 비용이 한블록 이동보다 작다면 대각선으로 쭉 가고 남은 것의 짝수만큼 대각선 이동 후 마지막 남은걸 블록 이동
		 */
		long ans = 0;
		if (w * 2 < s) {
			System.out.println((x+y) * w);
			return;
		}
		else if (w > s) {
			//대각선으로 쭉가기
			long mn = Math.min(x, y);
			ans = mn * s;
			x -= mn; y -= mn;
			//남은 길의 짝수 만큼 대각선 이동 후 마지막 남은건 블록 이동
			if (x == 0) {
				if (y % 2 == 0) ans += s * y;
				else {
					ans += (y-1) * s + w;
				}
			} else {
				if (x % 2 == 0) ans += s * x;
				else {
					ans += (x-1) * s + w;
				}
			}
		}
		else {
			//대각선으로 쭉가기
			long mn = Math.min(x, y);
			ans = mn * s;
			x -= mn; y -= mn;
			//남은건 블록 이동
			ans += x * w;
			ans += y * w;
		}
		System.out.println(ans);
	}
	
}
