import java.io.*;
import java.util.*;

public class B1181 {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        // 길이 짧은 순서 > 사전순
        String[] arr0 = new String[N];
        for (int i = 0; i < N; i++) {
            arr0[i] = br.readLine();
        }

        // 중복된 단어는 제거
        // Set으로 변경 -> 중복을 없앰
        HashSet<String> setList = new HashSet<>(Arrays.asList(arr0));
        // 다시 배열로 변경
        String[] arr = setList.toArray(new String[0]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // -1 : o2가 더 긴 것
                // 0 : 같음
                // 1 : o1이 더 긴 것
                if (o1.length() != o2.length()) {
                    // 길이가 짧은 단어 우선
                    return o1.length() - o2.length();
                }
                // 길이가 같으면 사전순 정렬
                return o1.compareTo(o2);
            }
        });

        for (String data : arr) {
            System.out.println(data);
        }

    }

}
