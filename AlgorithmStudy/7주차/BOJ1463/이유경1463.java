import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		int[] dp = new int[x + 1];
		
		for (int i = 2; i <= x; i++) {
		    dp[i] = dp[i - 1] + 1;

		    if (i % 2 == 0)
		        dp[i] = Math.min(dp[i], dp[i / 2] + 1);

		    if (i % 3 == 0)
		        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		

		System.out.println(dp[x]);
	}

	
	/*
	 * 재귀 호출 1번마다 스택 프레임 1개가 생성됨
	 * JVM의 스택 크기는 실행 시 고정되어 있음
	 * 이 문제는 x-1 호출로 인해 재귀 깊이가 최대 x까지 증가함
	 * Java는 꼬리 재귀 최적화를 지원하지 않아 스택 프레임이 계속 쌓임
	 * 따라서 입력이 큰 경우(Stack 깊이 큼) 재귀 방식은 StackOverflow / 시간초과 발생
	 */
	// 가장 작은 횟수를 반환 (Top-down DP - 재귀 사용)
	/*private static int func(int x) {
		if (x == 1)
			return 0;

		if (dp[x] != 0)
			return dp[x];

		int result = func(x - 1) + 1; // 1빼는 경우
		
		if (x % 3 == 0) { // 3으로 나누어 떨어지는 경우
			result = Math.min(result, func(x / 3) + 1);
		}
		if (x % 2 == 0) { // 2로 나누어 떨어지는 경우
			result = Math.min(result, func(x / 2) + 1);
		}
		
		dp[x] = result;
		return dp[x];
	}*/
}
