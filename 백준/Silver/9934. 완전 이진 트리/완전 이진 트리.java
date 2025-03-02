import java.io.*;
import java.util.*;

public class Main {

	
	static int N;
	static int[] arr;
	static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        N = (int) Math.pow(2, K) - 1;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        list = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        // 0 ~ N-1
        
        StringBuilder sb = new StringBuilder();
        int s = 0; int e = N - 1;
        go(s, e, 0);
        for (List<Integer> i : list) {
        	for (int j : i) {
        		sb.append(j).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    } // main
    
    static void go(int s, int e, int level) {
    	if (s > e) return;
    	int mid = (s + e) >>> 1;
    	list.get(level).add(arr[mid]);
    	go(s, mid - 1, level + 1);
    	go(mid + 1, e, level + 1);
    }

}