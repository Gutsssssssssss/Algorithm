import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] idxArr = new int[N+1];
		List<Integer> list = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int cur = arr[i];
			int pos = Collections.binarySearch(list, cur);
			if (pos >= 0) {
				idxArr[i] = pos;
				continue;
			} else {
				pos = (-pos - 1);
				if (pos == list.size()) {
					list.add(cur);
					cnt++;
				} else {
					list.set(pos, cur);
				}
			}
			idxArr[i] = pos;
		}
		System.out.println(cnt);
		Stack<Integer> stk = new Stack<Integer>();
		int idx = cnt;
		for (int i = N; i >= 1; i--) {
			if (idxArr[i] == idx - 1) {
				stk.add(arr[i]);
				idx--;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stk.isEmpty()) {
			sb.append(stk.pop()).append(" ");
		}
		System.out.println(sb);
	} // main
	
	
}