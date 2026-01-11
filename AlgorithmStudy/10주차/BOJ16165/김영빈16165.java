import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main16165 {
	
	static class Team {
		String name; // 팀이름
		Set<String> member; // 멤버
		
		public Team(String name) {
			this.name = name;
			this.member = new TreeSet<>(); // 멤버 이름 사전순 정렬
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<Team> set = new HashSet<>(); // Team 저장
		
		while(N-->0) {
			String teamName = br.readLine();
			Team team = new Team(teamName);
			int cnt = Integer.parseInt(br.readLine());
			while(cnt-->0) {
				team.member.add(br.readLine());
			}
			set.add(team);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			String str = br.readLine();
			int quiz = Integer.parseInt(br.readLine());
			
			for(Team t : set) {
				// 퀴즈가 1일때는 멤버가 속한 팀 이름 저장
				if(quiz==1) {
					if(t.member.contains(str)) {
						sb.append(t.name).append("\n");
						break;
					}
				} else { // 퀴즈가 0일때는 해당 팀의 멤버 전체 저장(이름-사전순)
					if(t.name.equals(str)) {
						for(String s : t.member) {
							sb.append(s).append("\n");
						}
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}
