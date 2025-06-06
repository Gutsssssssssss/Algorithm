import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N+1];
		if (N == 1) {
			System.out.println(arr[1]);
			return;
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	} // main
}