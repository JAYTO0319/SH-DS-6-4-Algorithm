
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세준이는 현재 (0, 0)
		// 집은 (X,Y)
		// 가로나 세로로 한 블록 움직이거나 대각선 가로지르기

		// 한 블록 가는데 걸리는 시간 W와 대각선으로 한 블록을 가로지르는 시간 S
		
		
		//2 0 12 10인 경우 -> 대각선 2번이 더 빠름 
		//이걸 고민해야함.
		
		String[] arr = br.readLine().split(" ");

    //int로 했을 때 테스트 케이스 6번에서 정확한 테스트 불가
    //long으로 변경해야함. 
		long X = Integer.parseInt(arr[0]);
		long Y = Integer.parseInt(arr[1]);
		long W = Integer.parseInt(arr[2]);
		long S = Integer.parseInt(arr[3]);
		
		long result = 0;

		// 가로세로 1칸씩 움직이는 것 < 한 블록을 가로지르는 시간
		if (2 * W <= S) {
			result = X*W + Y*W;
			//System.out.println("1번");
		}
		// 가로세로 1칸씩 움직이는 것 > 한 블록을 가로지르는 시간
		else if (2 * W > S) {
			//System.out.println("2번");
			//X와 Y가 같은 경우
			//X > Y
			//X < Y
			if(X==Y) {
				result = X*S;
			}else if(X > Y) {
				//만약 X-Y가 짝수이면 대각선
				//X-Y의 남은 거리 * W > X-Y의 남은 거리 * S 
				if((X-Y)%2==0 && (X-Y)*W > (X-Y)*S) {
					result = Y*S + (X-Y)*S;
				}
				//Y-X가 홀수이고 X-Y의 남은 거리 * W > X-Y의 남은 거리 * S 
				else if((X-Y)%2!=0 && (X-Y)*W > (X-Y)*S) {
					result = Y*S + (X-Y-1)*S + W;
				}else {
					result = Y*S + (X-Y)*W;
				}
			}else if(X < Y) {
				//만약 X-Y가 짝수이면 대각선이고
				//Y-X의 남은 거리 * W > Y-X의 남은 거리 * S 
				if((Y-X)%2==0 && (Y-X)*W > (Y-X)*S) {
					result = X*S + (Y-X)*S;
				}
				//Y-X가 홀수이고 Y-X의 남은 거리 * W > Y-X의 남은 거리 * S 
				else if((Y-X)%2!=0 && (Y-X)*W > (Y-X)*S) {
					result = X*S + (Y-X-1)*S + W;
				}else {
					result = X*S + (Y-X)*W;
				}
			}
		}
		System.out.println(result);

	}
}
