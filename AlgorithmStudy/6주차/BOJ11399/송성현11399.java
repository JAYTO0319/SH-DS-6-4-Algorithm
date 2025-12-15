import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		String[] P = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(P[i]));
		}
		//오름차순 정렬
		Collections.sort(list);
		
		int total = 0;
		int result = 0;
		for(int data:list) {
			total += data;
			result += total;
		}

		System.out.println(result);
	}

}
