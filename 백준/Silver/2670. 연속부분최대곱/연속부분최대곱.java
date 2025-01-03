import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		if (N == 1) {
			System.out.println(arr[1]);
			return;
		}
		double[] dp = new double[N+1];
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i-1] * arr[i], arr[i]);
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
//		System.out.printf("%.3f", Arrays.stream(dp).max().getAsDouble());
		System.out.println(String.format("%.3f", Arrays.stream(dp, 1, N).max().getAsDouble()));
	} // main
}