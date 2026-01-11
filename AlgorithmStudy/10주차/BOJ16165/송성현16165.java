
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ16165 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//총 입력 받을 걸그룹의 수 N
		int N = 0;
		//맞혀야 할 문제의 수 M
		int M = 0;
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		//멤버, 그룹명을 넣을 map
		Map<String, String> map = new HashMap<String, String>();
		//그룹명, 멤버를 넣을 map2
		Map<String, String[]> map2 = new LinkedHashMap<String, String[]>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			int count = Integer.parseInt(br.readLine());
			String[] arr = new String[count];
			for(int j=0; j<count; j++) {
				String mem = br.readLine();
				map.put(mem, name);
				arr[j] = mem;
			}
			//받아온 리스트 sort해서 map2에 넣기
			Arrays.sort(arr);
			map2.put(name, arr);
		}
		
		StringBuilder sb = new StringBuilder();
		//문제 수 만큼 for문 돌기
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			int num = Integer.parseInt(br.readLine());
			//0이면 멤버의 이름을 사전순
			if(num == 0) {
				for(String data:map2.get(name)) {
					sb.append(data + "\n");
				}
			//1이면 팀 이름 출력
			} else if(num == 1) {
				sb.append(map.get(name) + "\n");
			}
		}
		System.out.println(sb);
	}
}
