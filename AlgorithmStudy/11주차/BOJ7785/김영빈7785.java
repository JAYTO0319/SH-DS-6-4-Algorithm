import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main7785 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String> enterSet = new TreeSet<>((s1,s2)->s2.compareTo(s1));
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String io = st.nextToken();
			if(io.equals("enter")) {
				enterSet.add(name);
			} else {
				enterSet.remove(name);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : enterSet) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}

}
