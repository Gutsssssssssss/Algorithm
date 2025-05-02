
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int W = Integer.parseInt(st.nextToken());
        	int V = Integer.parseInt(st.nextToken());
        	arr[i][0] = W;
        	arr[i][1] = V;
        }
        
        int[] dp = new int[K+1];
        for (int i = 0; i < N; i++) {
        	for (int j = K; j >= arr[i][0]; j--) {
        		dp[j] = Math.max(dp[j], dp[j-arr[i][0]] + arr[i][1]);
        	}
        }
        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    } // main
    
}