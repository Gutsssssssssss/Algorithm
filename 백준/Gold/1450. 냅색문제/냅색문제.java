import java.io.*;
import java.util.*;

public class Main {

	static int N, C;
	static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int mid = (N / 2);
        List<Long> list1 = new ArrayList<Long>(); 
        List<Long> list2 = new ArrayList<Long>(); 
        go(0, mid, list1, 0);
        go(mid, N, list2, 0);
        
        Collections.sort(list2);
        long cnt = 0;
        for (long cur : list1) {
        	if (C - cur < 0) continue;
        	long pos = upperbound((C - cur), list2);
        	cnt += pos;
        }
        System.out.println(cnt);
    } // main
    static int upperbound(long val, List<Long> list) {
    	int lo = 0;
    	int hi = list.size() - 1;
    	while (lo <= hi) {
    		int mid = (lo + hi) >>> 1;
        	if (val >= list.get(mid)) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        	}
    	}
    	return lo;
    }
    
    static void go(int s, int e, List<Long> list, long sum) {
    	if (s == e) {
    		list.add(sum);
    		return;
    	}
    	
    	go(s + 1, e, list, sum);
    	go(s + 1, e, list, sum + arr[s]);
    	
    }

}