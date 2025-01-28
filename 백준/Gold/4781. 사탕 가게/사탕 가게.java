import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			String[] srr = s.split("\\.");
			
			
			int M = Integer.parseInt(srr[0]) * 100 + Integer.parseInt(srr[1]);
			if (N == 0 && M == 0) break;
			int[] dp = new int[M+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				srr = st.nextToken().split("\\.");
				int b = Integer.parseInt(srr[0]) * 100 + Integer.parseInt(srr[1]);
				
				for (int j = b; j <= M; j++) {
					dp[j] = Math.max(dp[j], dp[j-b] + a);
				}
			}
			System.out.println(dp[M]);
		}
	} // main
}