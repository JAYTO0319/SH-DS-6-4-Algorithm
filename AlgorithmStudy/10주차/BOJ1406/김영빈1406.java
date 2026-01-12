import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main1406 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] str = br.readLine().split("");
		
		Deque<String> left = new ArrayDeque<>();
		Deque<String> right = new ArrayDeque<>();
		
		for(String s : str) {
			left.add(s);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		while(M-->0){
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
				case "L" -> {
					if(!left.isEmpty()) right.add(left.pollLast());
				}
				case "D" -> {
					if(!right.isEmpty()) left.add(right.pollLast());
				}
				case "B" -> {
					if(!left.isEmpty()) left.pollLast();
				}
				case "P" -> {
					left.add(st.nextToken());
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!left.isEmpty()) {
			sb.append(left.pollFirst());
		}
		while(!right.isEmpty()) {
			sb.append(right.pollLast());
		}
		
		System.out.println(sb);
	}

}
