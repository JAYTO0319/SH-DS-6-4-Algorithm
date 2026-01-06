import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            int[] a = new int[l];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<l; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st =  new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            for(int j=0; j<l; j++) {
                for(int k=0; k<m; k++) {
                    if(a[j] > b[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
