import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = n - 1; i >= 0; i--){ // 뒤에서부터 넣기 -> 내림차순 정렬
            coins[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            total += k / coins[i];
            k %= coins[i];

            if(k == 0) break;
        }
        System.out.println(total);
    }
}
