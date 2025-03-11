import java.io.*;
import java.util.*;

public class Main {
	
	static int K, N;
	static List<List<Integer>> tree;
	static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        K = Integer.parseInt(br.readLine());
        tree = new ArrayList<List<Integer>>();
        for (int i = 0; i < K; i++) {
        	tree.add(new ArrayList<Integer>());
        }
        
        N = (int) Math.pow(2, K) - 1;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        go(0, N - 1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
        	for (int j : tree.get(i)) {
        		sb.append(j).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
    } // main
    
    static void go(int s, int e, int level) {
    	if (s > e) return;
    	int mid = (s + e) >>> 1;
    	tree.get(level).add(arr[mid]);
    	go(s, mid - 1, level + 1);
    	go(mid + 1, e, level + 1);
    }
    
}
