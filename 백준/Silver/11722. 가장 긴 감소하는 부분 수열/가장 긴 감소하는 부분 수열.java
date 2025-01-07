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
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1]; // i 번째 수가 마지막인 감소하는 수열
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	} // main
}