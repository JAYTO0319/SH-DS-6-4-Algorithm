import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());

        int bestScore = -1;
        int bestIdx = -1;

        for (int idx = 1; idx <= n; idx++) {
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[5];
            for (int i = 0; i < 5; i++) nums[i] = Integer.parseInt(st.nextToken());

            int maxScore = 0;

            // 5개 중 3개를 고르는 모든 조합
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        int score = sum % 10;
                        if (score > maxScore) maxScore = score;
                    }
                }
            }

            // 전체 최고 갱신: 동점이면 “번호가 큰 사람”
            if (maxScore > bestScore || (maxScore == bestScore && idx > bestIdx)) {
                bestScore = maxScore;
                bestIdx = idx;
            }
        }

        System.out.println(bestIdx);
    }
}
