import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer,Integer> map = new HashMap<>();
		
		List<Integer> list;
		
		for(int i=1; i<=N; i++) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int max = 0;
			for(int j=0;j<3;j++) {
				for(int k=j+1;k<4;k++) {
					for(int l=k+1; l<5;l++) {
						int sum = list.get(j) + list.get(k) + list.get(l);
						int one = sum%10;
						if(one>max) {
							max = one;
						}
					}
				}
			}
			map.put(i, max);
		}
		
		List<Entry<Integer,Integer>> list2 = new ArrayList<>();
		for(Entry<Integer,Integer> e : map.entrySet()) {
			list2.add(e);
		}
		
		list2.sort((e1,e2)->{
			if(e1.getValue().equals(e2.getValue())) {
				return e2.getKey() - e1.getKey();
			} else {
				return e2.getValue() - e1.getValue();
			}
		});
		
		System.out.println(list2.get(0).getKey());
	}
}
