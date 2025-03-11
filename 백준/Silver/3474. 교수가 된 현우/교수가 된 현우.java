
import java.io.*;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int T = 1; T <= TC; T++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int cnt = 0;
        	for (int i = 5; i <= N; i *= 5) {
        		cnt += (N / i);
        	}
        	sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    } // main
    
}
