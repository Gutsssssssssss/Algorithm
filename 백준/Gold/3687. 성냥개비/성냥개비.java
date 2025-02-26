import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static String[] dp;
	static final String INF = "111111111111111111111111111111111111111111111111111";
	static int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	static List<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new String[101];
		
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= N; T++) {
			M = Integer.parseInt(br.readLine());
			Arrays.fill(dp, INF);
			String mx = max(M);
			String mn = go(M);
			sb.append(mn).append(" ").append(mx).append("\n");
		}
		System.out.println(sb);
	} // main
	static String max(int here) {
		String ret = "";
		if (here % 2 == 1) {
			ret += "7";
			here -= 3;
		}
		
		while (here > 0) {
			ret += "1";
			here -= 2;
		}
		return ret;
	}
	static String go(int cur) {
		
		if (cur == 0) {
			return "";
		}
		
		if (dp[cur] != INF) {
			return dp[cur];
		}
		String ret = INF;
		for (int i = 0; i <= 9; i++) {
			if (cur - arr[i] < 0) continue;
			if (cur == M && i == 0) continue;
			ret = findMin(ret, ("" + i + go(cur - arr[i])));
		}
		
		return dp[cur] = ret;
	}
	
	static String findMin(String a, String b) { 
		if (a.length() == b.length()) {
			if (a.compareTo(b) < 0) {
				return a;
			} else return b;
		}
		
		return a.length() < b.length() ? a : b;
	}
}