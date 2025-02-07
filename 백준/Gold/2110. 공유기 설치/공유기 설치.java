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
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int lo = 1; int hi = arr[N-1] - arr[0];
		
		int ret = 0;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			
			if (check(mid)) {
				lo = mid + 1;
				ret = mid;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ret);
	} // main

	static boolean check(int mid) {
		int temp = arr[0];
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (temp + mid <= arr[i]) {
				temp = arr[i];
				cnt++;
			}
		}
		return cnt >= M;
	}
}