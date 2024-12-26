import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 1, 2, 3, 4, 5
    // 한 번에 선택할 수 있는 선택지: 1 또는 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n+1];
        dp[1] = true;
        if(n>=2) dp[2] = false;
        if(n>=3) dp[3] = true;

        for(int i=4; i<=n; i++) {
            dp[i] = !dp[i-1] || !dp[i-3];
        }
        System.out.println(dp[n] == true ? "SK" : "CY");
    }
}