import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1260 {
	
	public static LinkedList<Integer> adj[];
	public static boolean visited[];
	public static StringBuilder sb;

	//백준 1260번 DFS와 BFS
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 노드 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		int V = Integer.parseInt(st.nextToken()); // 시작 노드 번호
		
		// 각 노드별로 인접한 노드를 LinkedList에 저장
		adj = new LinkedList[N+1];
		
		// 노드별 LinkedList 초기화
		for(int i=1; i<=N; i++) {
			adj[i] = new LinkedList();
		}
		
		// 인접한 노드, 간선 저장
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// 간선 양방향 저장
			adj[v].add(w);
			adj[w].add(v);
		}
		
		// 노드별 인접한 노드 번호 오름차순 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(adj[i]);
		}
		
		sb = new StringBuilder();
		// 노드 방문 여부 저장을 위한 visited 배열 초기화
		visited = new boolean[N+1];
		DFS(V);
		
		sb.append("\n");
		
		// 노드 방문 여부 저장을 위한 visited 배열 초기화
		visited = new boolean[N+1];
		BFS(V);
		
		System.out.println(sb);
	}

	// 너비 우선 탐색 (BFS)
	private static void BFS(int v) {
		// 탐색할 노드 추가할 queue (FIFO) -> level 별 탐색 (너비 우선)
		Deque<Integer> queue = new ArrayDeque<>();
		visited[v] = true; // 방문한 노드(true)로 상태 변경
		queue.add(v); // queue에 추가
		
		// queue에 순회할 노드가 없을 때까지 반복
		while(!queue.isEmpty()) {
			// queue의 가장 맨 앞 노드를 poll
			int x = queue.poll();
			sb.append(x).append(" ");
			// 인접한 노드 순회
			for(int y : adj[x]) {
				// 방문하지 않은 노드일 경우 true로 상태 변경 후 queue에 추가
				if(!visited[y]) {
					visited[y] = true;
					queue.add(y);
				}
			}
		}
	}
	
	// 깊이 우선 탐색 (DFS)
	private static void DFS(int v) {
		// 이미 방문한 노드일 경우 return
		if(visited[v]) {
			return;
		}
		
		sb.append(v).append(" ");
		visited[v] = true; // 방문한 노드(true)로 상태 변경
		// 인접한 노드 순회
		for(int i : adj[v]) {
			// 방문하지 않은 노드일 경우 재귀 호출을 통해 탐색 -> 깊이 우선
			if(!visited[i]) {
				DFS(i);
			}
		}
	}

}
