import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> qu = new ArrayDeque<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=N; i++) {
			qu.add(i);
		}
		while(!qu.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				qu.add(qu.poll());
			}
			list.add(qu.poll());
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		for(int data:list) {
			sb.append(data + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
		
	}

}
