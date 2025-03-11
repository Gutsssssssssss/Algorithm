

import java.io.*;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
        	while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
        		ans[stk.pop()] = arr[i];
        	}
        	stk.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    } // main
   
}
