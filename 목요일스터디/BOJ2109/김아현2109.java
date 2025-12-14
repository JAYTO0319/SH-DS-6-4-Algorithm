import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 김아현2109 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		int n = Integer.parseInt(bufferedReader.readLine());
		int sum = 0;

		// 강연료(p)와 날짜(d)를 묶어서 관리
		int[][] lectures = new int[n][2];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			lectures[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			lectures[i][1] = Integer.parseInt(stringTokenizer.nextToken());
		}

		// 날짜(lectures[i][1])를 기준으로 오름차순
		Arrays.sort(lectures, (o1, o2) -> {
			return o1[1] - o2[1];
		});

		for (int i = 0; i < n; i++) {
			priorityQueue.offer(lectures[i][0]);
			if (priorityQueue.size() > lectures[i][1]) {
				priorityQueue.poll(); // 최소 힙으로 구현했기 때문에, 가장 작은 값(루트) 제거됨
			}
		}
		while (!priorityQueue.isEmpty()) {
			sum += priorityQueue.poll();
		}

		System.out.println(sum);
	}
}