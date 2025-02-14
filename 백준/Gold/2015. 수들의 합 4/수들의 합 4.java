import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] psum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        
        long sum = 0;
        for (int i = 1; i <= N; i++) {
        	int ans = map.getOrDefault(psum[i] - K, 0);
        	map.put(psum[i], map.getOrDefault(psum[i], 0) + 1);
        	sum += ans;
        }
        System.out.println(sum);
    } // main
    
}