import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 남아있는 숫자 문자열
        // 예) 입력 "234092"
        String s = br.readLine().trim();
        
        // 현재 비교를 위한 문자열의 포인터 (앞부분부터 매칭)
        int pointer = 0;

        // 숫자를 하나씩 늘려가며 이어쓴다고 가정
        // 이 값이 최종 N을 구할 변수
        int num = 0;

        // while문을 돌며 pointer가 문자열 길이를 벗어나지 않을 때까지
        // 계속해서 숫자를 증가시키며 비교한다
        while (pointer < s.length()) {
            num++; // num을 하나 증가시키며 이어쓰기

            // 숫자 num을 문자열로 변환 (1 -> "1", 12 -> "12")
            String cur = Integer.toString(num);

            // cur 문자열의 각 자릿수와 입력 문자열의 일치여부 검사
            // 만약 일치하면 pointer 증가
            for (int i = 0; i < cur.length() && pointer < s.length(); i++) {
                // s.charAt(pointer)와 cur.charAt(i)가 같다면
                // 입력 문자열에서 하나를 "사용한 것"으로 간주
                if (s.charAt(pointer) == cur.charAt(i)) {
                    pointer++;
                }
            }
        }

        // pointer가 입력 문자열 끝까지 소화되면
        // 그때의 num이 곧 가능한 최소 N
        System.out.println(num);
    }
}
