

import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        int[] dp = new int[65];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 1; i <= 64; i*=2) {
        	dp[i] = 1;
        }
        
        for (int i = 1; i <= 64; i++) {
        	for (int j = 1; j < i; j++) {
        		dp[i] = Math.min(dp[i], dp[j] + dp[i-j]); 
        	}
        }
        System.out.println(dp[X]);
    } // main

}