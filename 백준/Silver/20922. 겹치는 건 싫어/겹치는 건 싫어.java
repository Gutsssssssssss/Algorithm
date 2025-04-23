
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] cnt = new int[100001];
        
        int lo = 0; int hi = 0;
        int mxLen = 0;
        cnt[arr[hi]]++; 
        while (hi + 1 < N) {
        		hi++;
            	cnt[arr[hi]]++;
        	
        	
        	while (lo < N && K < cnt[arr[hi]]) {
        		cnt[arr[lo]]--;
        		lo++;
        	}
        	mxLen = Math.max(mxLen, hi - lo);
        }
        System.out.println(mxLen + 1);
    } // main

   
}