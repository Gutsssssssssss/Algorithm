import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			int[] arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = arr[i-1] + num;
			}
			
			Arrays.fill(dp, -1_000_000);
			
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 0; j < i; j++) {
					sum = arr[i] - arr[j];
					dp[i] = Math.max(dp[i], sum);
				}
	
			}
			sb.append(Arrays.stream(dp).max().getAsInt()).append("\n");
		} // TC
		System.out.println(sb);
	} // main
}