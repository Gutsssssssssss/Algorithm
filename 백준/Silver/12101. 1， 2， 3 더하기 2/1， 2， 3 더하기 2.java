import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<String>[] dp = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			dp[i] = new ArrayList<String>();
		}
		
		dp[1].add("1");
		if (N == 1) {
			
			if (K > dp[N].size()) {
				System.out.println(-1);
				return;
			} else {
				System.out.println(dp[N].get(K-1));
			}
			return;
		}
		dp[2].add("1+1");
		dp[2].add("2");
		if (N == 2) {
			if (K > dp[N].size()) {
				System.out.println(-1);
				return;
			} else {
				System.out.println(dp[N].get(K-1));
			}
			return;
		}
		dp[3].add("1+1+1");
		dp[3].add("1+2");
		dp[3].add("2+1");
		dp[3].add("3");
		
		for (int i = 4; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 0; k < dp[i-j].size(); k++) {
					dp[i].add(j + "+" + dp[i-j].get(k));
				}
			}
		}
		if (K > dp[N].size()) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(dp[N].get(K-1));
		}
	} // main
	
	
}