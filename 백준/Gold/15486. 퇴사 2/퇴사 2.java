import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N+1];
		int[] pay = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+2];
		for (int i = 1; i <= N; i++) {
			int t = time[i];
			int p = pay[i];
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			if (i + t - 1 > N) continue;
			dp[i + t] = Math.max(dp[i + t], dp[i] + p);
			
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	} // main
}