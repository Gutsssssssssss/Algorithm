import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 // 1 2 3
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char[] arr = s.toCharArray();
		Map<Character, Character> map = new HashMap<>();
		map.put('B', 'O');
		map.put('O', 'J');
		map.put('J', 'B');
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[1] = 0;
				
		for (int i = 1; i < N; i++) {
			char cur = arr[i-1];
			for (int j = i + 1; j <= N; j++) {
				char next = arr[j-1];
				if (map.get(cur) == next) {
					dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
				}
			}
		}
		System.out.println(dp[N] == Integer.MAX_VALUE / 2 ? -1 : dp[N]);
	} // main
}