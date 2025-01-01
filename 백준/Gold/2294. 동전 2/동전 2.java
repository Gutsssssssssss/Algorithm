import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] a;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            for(int j=1; j<=k; j++) {
                if(j-a[i]<0) continue;
                dp[j] = Math.min(dp[j], dp[j-a[i]] + 1);
            }
        }
        if(dp[k] == Integer.MAX_VALUE/2) System.out.println(-1);
        else System.out.println(dp[k]);
    } // main
} // class