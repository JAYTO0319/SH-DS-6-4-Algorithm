
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class bj2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			set.add(num);
		}
		
		List<Integer> list = new ArrayList<Integer>(set);
		
		Collections.sort(list);
		
		for(int data:list) {
			System.out.println(data);
		}
		
	}
}
