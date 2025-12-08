
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class bj1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N(1 ≤ N ≤ 100,000)이 주어진다
		int N = Integer.parseInt(br.readLine());
		
		//list를 사용해서 비교했더니 시간초과 -> hashset이 list보다 찾는 것이 더 빠르다.
		//List<String> N_set = new ArrayList<String>();
		
		Set<String> N_set = new HashSet<String>();
		
		// N개의 정수 A[1], A[2], …, A[N]
		String[] N_data = br.readLine().split(" ");

		for(String data:N_data) {
			N_set.add(data);
		}
		//M(1 ≤ M ≤ 100,000)이 주어진다
		int M = Integer.parseInt(br.readLine());
		List<String> M_list = new ArrayList<String>();
		
		// M개의 정수 [1], [2], …, [N]
		String[] M_data = br.readLine().split(" ");
		
		for(String data:M_list) {
			M_list.add(data);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String in_there:M_data) {
			sb.append(N_set.contains(in_there)?1+"\n":0+"\n");
		}
		System.out.println(sb);
	}

}
