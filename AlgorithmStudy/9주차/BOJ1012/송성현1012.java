package selfstudy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int co = 0; co < T; co++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] visited = new boolean[M][N];
			int[][] farm = new int[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					farm[i][j] = 0;
					visited[i][j] = false;
				}
			}

			for (int i = 0; i < K; i++) {
				StringTokenizer baechu = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(baechu.nextToken());
				int b = Integer.parseInt(baechu.nextToken());
				farm[a][b] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
				}
			}
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					Queue<int[]> qu = new ArrayDeque<int[]>();
					if (farm[i][j] == 1 && visited[i][j] != true) {
						qu.add(new int[] { i, j });
						count++;
					}
					while (!qu.isEmpty()) {
						int[] output = qu.poll();
						int k = output[0];
						int p = output[1];
						visited[k][p] = true;
						if (k > 0) {
							if (farm[k - 1][p] == 1 && visited[k - 1][p] == false) {
								qu.add(new int[] { k - 1, p });
								visited[k - 1][p] = true;
							}
						}
						if (k < M - 1) {
							if (farm[k + 1][p] == 1 && visited[k + 1][p] == false) {
								qu.add(new int[] { k + 1, p });
								visited[k + 1][p] = true;
							}
						}
						if (p > 0) {
							if (farm[k][p - 1] == 1 && visited[k][p - 1] == false) {
								qu.add(new int[] { k, p - 1 });
								visited[k][p - 1] = true;
							}
						}
						if (p < N - 1) {
							if (farm[k][p + 1] == 1 && visited[k][p + 1] == false) {
								qu.add(new int[] { k, p + 1 });
								visited[k][p + 1] = true;
							}
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
