import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 줄: N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 팀명 -> 멤버 리스트 저장 Map
        HashMap<String, ArrayList<String>> teamMap = new HashMap<>();

        // 멤버명 -> 소속팀명 저장 Map
        HashMap<String, String> memberMap = new HashMap<>();

        // 각 팀 정보 입력
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine().trim();
            int count = Integer.parseInt(br.readLine().trim());

            teamMap.put(teamName, new ArrayList<>());

            // 멤버들 입력
            for (int j = 0; j < count; j++) {
                String mem = br.readLine().trim();
                teamMap.get(teamName).add(mem);

                // 멤버 이름으로 팀 이름 저장
                memberMap.put(mem, teamName);
            }
        }

        // 퀴즈 처리
        for (int i = 0; i < M; i++) {
            String query = br.readLine().trim();
            int type = Integer.parseInt(br.readLine().trim());

            // type 0: 팀명 -> 멤버 출력
            if (type == 0) {
                ArrayList<String> members = teamMap.get(query);
                Collections.sort(members); // 사전순 정렬
                for (String mem : members) {
                    sb.append(mem).append("\n");
                }
            } 
            // type 1: 멤버명 -> 팀명
            else {
                sb.append(memberMap.get(query)).append("\n");
            }
        }

        // 한 번에 출력
        System.out.print(sb.toString());
    }
}
