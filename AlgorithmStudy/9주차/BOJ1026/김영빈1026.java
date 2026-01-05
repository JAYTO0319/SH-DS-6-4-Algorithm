import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			listA.add(Integer.parseInt(st1.nextToken()));
			listB.add(Integer.parseInt(st2.nextToken()));
		}
		
		listA.sort((x,y)->x-y);
		listB.sort((x,y)->y-x);
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += listA.get(i) * listB.get(i);
		}
		
		System.out.println(sum);
	}
}
