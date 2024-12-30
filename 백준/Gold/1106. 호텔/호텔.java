import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[C+101];
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			int cost = arr[i][0];
			int cnt = arr[i][1];
			for (int j = cnt; j <= C + 100; j++) {
				dp[j] = Math.min(dp[j], dp[j-cnt] + cost);
			}
		}
//		for (int i = C; i <= C+100; i++) {
//			System.out.print(dp[i] + " ");
//		}
		System.out.println(Arrays.stream(dp, C, C + 100)
				.min()
				.getAsInt());
	} // main
}