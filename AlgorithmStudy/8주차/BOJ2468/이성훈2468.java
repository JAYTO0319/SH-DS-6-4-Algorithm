package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
	
	public static class XY{
		int x;
		int y;
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] height = new int[n][n];
		
		int max = 0;
		
		for(int i = 0 ; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, height[i][j]);
			}
		}
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		boolean[][] visited = new boolean[n][n];
		
		int answer = 0;
		for(int rain = 0; rain < max; rain++) {
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j < n; j++) {
					visited[i][j] = height[i][j] <= rain;
				}
			}
			
			int count = 0;
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j < n; j++) {
					if(visited[i][j]) continue;
					
					
					Deque<XY> queue = new ArrayDeque<XY>();
					queue.add(new XY(i,j));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						XY cur = queue.pollFirst();
						for(int a = 0; a < 4; a++) {
							int nextX = cur.x + dx[a];
							int nextY = cur.y + dy[a];
							if(nextX < 0 || nextX >=n) continue;
							if(nextY < 0 || nextY >=n) continue;
							if(visited[nextX][nextY]) continue;
							
							queue.add(new XY(nextX,nextY));
							visited[nextX][nextY] = true;
							
						}
					}
					count ++;
				}
			}
			answer = Math.max(answer, count);
			
		}
		
		System.out.println(answer);
		
	}

}
