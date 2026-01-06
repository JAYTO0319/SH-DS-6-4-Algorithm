import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> groupToMember = new HashMap<>();
        Map<String, String> memberToGroup = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int repeat = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();

            for (int j = 0; j < repeat; j++) {
                String member = br.readLine();
                members.add(member);
                memberToGroup.put(member, groupName);
            }

            Collections.sort(members);
            groupToMember.put(groupName, members);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 1) {
                bw.write(memberToGroup.get(name) + "\n");
            } else {
                for (String member : groupToMember.get(name)) {
                    bw.write(member + "\n");
                }
            }
        }
        bw.flush();
    }
}
