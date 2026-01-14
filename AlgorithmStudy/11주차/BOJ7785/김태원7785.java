import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashSet<String> set = new HashSet<>();
		while (n-->0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String move = st.nextToken();
			if (move.equals("leave")) set.remove(name);
			else set.add(name);
		}
		String[] list = set.toArray(new String[0]);
		Arrays.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i = list.length - 1; i >= 0; i--) {
			sb.append(list[i]).append("\n");
		}
		System.out.println(sb);
	}
	
}
