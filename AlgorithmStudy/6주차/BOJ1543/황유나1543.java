import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        
        int count = 0;
        int i = 0;
        while(i < doc.length()){
            // 인덱스가 유효할 때, 단어가 일치하는지 검사
            if(i + word.length() <= doc.length()){
                String cur_word = doc.substring(i, i + word.length());
                if(cur_word.equals(word)){
                    count++;
                    i += word.length();
                    continue;
                }
            }
            i++;
        }
        System.out.println(count);
    }
}
