

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
				ans[stk.peek()] = arr[i];
				stk.pop();
			}
			stk.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < N; i++)
		sb.append(ans[i]).append(" ");
		System.out.println(sb);
	} // main
}
