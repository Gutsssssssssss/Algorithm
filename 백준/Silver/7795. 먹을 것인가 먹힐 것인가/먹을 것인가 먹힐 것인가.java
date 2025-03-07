

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(B);
			int ans = 0;
			for (int i : A) {
				ans += upperbound(i, B);
				
			}
			System.out.println(ans);
		}
	} // main
	static int upperbound(int val, int[] B) {
		int lo = 0; int hi = B.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (val > B[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}
}
