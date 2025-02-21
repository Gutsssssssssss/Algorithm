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
        
        List<Long> list1 = new ArrayList<Long>();
        List<Long> list2 = new ArrayList<Long>();
        go(0, N / 2, list1, 0);
        go(N / 2, N, list2, 0);
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        long sum = 0;
        for (Long cur : list1) {
        	if (cur > C) continue;
        	int val = upperbound(list2, (C - cur));
        	sum += val;
        }
        System.out.println(sum);
    } // main
    
    static int upperbound(List<Long> list, long val) {
    	int lo = 0; int hi = list.size() - 1;
    	while (lo <= hi) {
    		int mid = (lo + hi) >>> 1;
    		if (list.get(mid) <= val) {
    			lo = mid + 1;
    		} else {
    			hi = mid - 1;
    		}
    	}
    	return lo;
    }
    
    static void go(int start, int end, List<Long> list, long sum) {
    	if (start == end) {
    		list.add(sum);
    		return;
    	}
    	
    	go(start + 1, end, list, sum);
    	go(start + 1, end, list, sum + arr[start]);
    }
}