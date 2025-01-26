import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            n = Integer.parseInt(br.readLine());
            dp = new long[n+1][n+1];
            if(n == 0) break;
            sb.append(go(n, 0)).append("\n");
        }
        System.out.println(sb);
    }
    static long go(int whole, int half) {
        if(whole == 0 && half == 0) return 1;
        if(dp[whole][half] != 0) return dp[whole][half];
        if(whole>0) dp[whole][half] += go(whole-1, half+1);
        if(half>0) dp[whole][half] += go(whole, half-1);
        return dp[whole][half];
    }
}