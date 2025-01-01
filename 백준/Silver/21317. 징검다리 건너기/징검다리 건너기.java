import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] sj = new int[N];
		int[] bj = new int[N];
		if (N == 1) {
			System.out.println(0);
			return;
		}
		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sj[i] = Integer.parseInt(st.nextToken());
			bj[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][N+1];
		// dp i j 
		// i -> K를 사용하는지 여부 0 이면 사용 안함
		// dp -> j번째까지 왔을 때의 에너지
		dp[0][2] = dp[1][2] = sj[1];
		if (N == 2) {
			System.out.println(sj[1]);
			return;
		}
 		dp[0][3] = dp[1][3] = Math.min(sj[2] + sj[1], bj[1]);
		
		for (int i = 4; i <= N; i++) {
			dp[0][i] = Math.min(dp[0][i-1] + sj[i-1], dp[0][i-2] + bj[i-2]);
			dp[1][i] = Math.min(Math.min(dp[1][i-1] + sj[i-1], dp[1][i-2] + bj[i-2]), dp[0][i-3] + K);
		}
		System.out.println(Math.min(dp[0][N], dp[1][N]));
//		System.out.println();
//		for (int i = 1; i <= N - 1; i++) {
//			System.out.print(dp[1][i] + " ");
//		}
	} // main
}