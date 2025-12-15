import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 김아현11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[] A = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = N-1; i >= 0; i--){
            int result = 0;
            if(K / A[i] >= 1){
                result= K / A[i];
                count += result;
                K = K - result * A[i];
            }
        }
        System.out.println(count);
    }
}
