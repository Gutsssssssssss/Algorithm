
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	lo = Math.max(arr[i], lo);
        	hi += arr[i];
        }
        
        int ret = 0;
        while (lo <= hi) {
        	int mid = (lo + hi) >>> 1;
        	if (check(mid)) {
        		hi = mid - 1;
        		ret = mid;
        	} else {
        		lo = mid + 1;
        	}
        }
        System.out.println(ret);
    } // main
    
    static boolean check(int mid) {
    	int cnt = 1;
    	int temp = mid;
    	for (int i = 0; i < N; i++) {
    		if (temp - arr[i] < 0) {
    			temp = mid;
    			cnt++;
    		}
    		temp -= arr[i];
    	}
    	return cnt <= M;
    }
}
