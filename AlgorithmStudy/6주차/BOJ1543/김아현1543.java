import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 김아현1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String search = bufferedReader.readLine();
        int count = 0;

        while(!input.isEmpty()){
            if(input.startsWith(search)){
                input = input.substring(search.length());
                count++;
            }
            else{
                input = input.substring(1);
            }
        }
        System.out.println(count);
    }
}