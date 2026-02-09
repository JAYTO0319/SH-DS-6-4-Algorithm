import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        // 백준 1251 단어 나누기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 2; i < str.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(str.substring(0, j));
                StringBuilder sb2 = new StringBuilder(str.substring(j, i));
                StringBuilder sb3 = new StringBuilder(str.substring(i));

                String s1 = sb1.reverse().toString();
                String s2 = sb2.reverse().toString();
                String s3 = sb3.reverse().toString();

                list.add(s1 + s2 + s3);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
