import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[1] = 1;
		// dp i -> i번째에 도달할 수 있는 최소 점프 수
		for (int i = 1; i <= N; i++) {
			int cnt = arr[i];
			for (int j = 1; j <= cnt; j++) {
				if (i + j > N) continue;
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}
		if (dp[N] == Integer.MAX_VALUE / 2) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N] - 1);
		}
	} // main
}