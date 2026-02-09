import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main11866 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new LinkedList<>();
		List<Integer> answer = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int start = -1;
		
		while(!list.isEmpty()) {
			start += K;
			if(start>list.size()-1) {
				start %= list.size();
			}
			answer.add(list.get(start));
			list.remove(start--);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for(int i=0; i<answer.size(); i++) {
			if(i==answer.size()-1) {
				sb.append(answer.get(i)).append(">");
				break;
			}
			sb.append(answer.get(i)).append(", ");
		}
		
		System.out.println(sb);
	}

}
