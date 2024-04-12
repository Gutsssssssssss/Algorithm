import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1001;
	static int n, ret=Integer.MAX_VALUE;
	static int[][] dp, a; // R G B
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n][3];
		a = new int[n][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int first = 0; first<3; first++) {
			for(int i=0; i<3; i++) {
				if(first==i) dp[0][first] = a[0][first];
				else dp[0][i] = INF;
			}
			
			for(int i=1; i<n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i][2];
			}
			for(int i=0; i<3; i++) {
				if(first == i) continue;
				ret = Math.min(ret, dp[n-1][i]);
			}
		}
		System.out.println(ret);
	} // end of main
} // end of class