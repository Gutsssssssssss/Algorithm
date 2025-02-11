import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int hi = 0;
		arr = new int[M+1];
		for (int i = 1; i <= M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hi = Math.max(hi, arr[i]);
		}
		
		int lo = 1;
		
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
		int cnt = 0;
		for (int i = 1; i <= M; i++) {
			cnt += (arr[i] / mid);
			cnt += (arr[i] % mid == 0 ? 0 : 1);
		}
		return N >= cnt;
	}
	
	
	
}