import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 멤버 이름 입력 시 팀 이름 출력
		// 팀 이름 입력 시 멤버 이름 출력
		// Map에 <팀 이름, 멤버 목록>, <멤버 이름, 팀 이름> 저장
		HashMap<String, String[]> tToM = new HashMap<>();
		HashMap<String, String> mToT = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String tName = br.readLine();
			int num = Integer.parseInt(br.readLine());
			String[] members = new String[num];
			for (int j = 0; j < num; j++) {
				String mName = br.readLine();
				mToT.put(mName, tName);
				members[j] = mName;
			}
			Arrays.sort(members);
			tToM.put(tName, members);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String keyword = br.readLine();
			int cmd = Integer.parseInt(br.readLine());
			if (cmd == 0)
				for (String name : tToM.get(keyword))
					sb.append(name).append("\n");
			else 
				sb.append(mToT.get(keyword)).append("\n");
			
		}
		System.out.println(sb);
	}

}
