import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 김아현16165 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String[]> map = new HashMap<>(); // Map<팀명, 팀원>

		for (int i = 0; i < N; i++) {
			String tname = br.readLine();
			int count = Integer.parseInt(br.readLine());
			String[] member = new String[count];

			for (int j = 0; j < count; j++) {
				member[j] = br.readLine();
			}

			Arrays.sort(member); // 멤버의 이름을 사전순으로 정렬
			map.put(tname, member);
		}
		
		for(int i = 0; i < M; i++) {
			String mname = br.readLine();
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) // 멤버 이름 전부 출력
				for(String member: map.get(mname)) {
					System.out.println(member);
				}
			else if(num == 1) { // 팀의 이름 출력
				for(String groupname: map.keySet()) {
					if(Arrays.asList(map.get(groupname)).contains(mname))
						System.out.println(groupname);
				}
			}
		}

		br.close();
	}
}
