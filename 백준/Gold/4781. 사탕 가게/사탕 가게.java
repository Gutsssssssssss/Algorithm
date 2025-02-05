import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] sr = st.nextToken().split("\\.");
			int K = Integer.parseInt(sr[0]) * 100 + Integer.parseInt(sr[1]);
			if (N == 0 && K == 0) {
				break;
			}
			int[] dp = new int[K+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				String[] sr2 = st.nextToken().split("\\.");
				int p = Integer.parseInt(sr2[0]) * 100 + Integer.parseInt(sr2[1]);
				for (int j = p; j <= K; j++) {
					dp[j] = Math.max(dp[j], dp[j-p] + c);
				}

			}
			System.out.println(dp[K]);
		}
	} // main

}