

import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
        	while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
        		int temp = stk.pop();
        		ans[temp] = arr[i];
        	}
        	stk.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
        	sb.append(i).append(" ");
        }
        System.out.println(sb);
    } // main
    
}
