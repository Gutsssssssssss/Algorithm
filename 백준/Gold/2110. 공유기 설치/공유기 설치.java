import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int mn = Integer.MAX_VALUE / 2;
		int mx = -1;
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			mx = Math.max(mx, arr[i]);
			mn = Math.min(mn, arr[i]);
		}
		
		Arrays.sort(arr);
		
		int lo = 1; int hi = arr[N-1] - arr[0];
		int ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			
			if (check(mid)) {
				lo = mid + 1;
				ans = mid;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	} // main
	static boolean check(int mid) {
		int ret = 1;
		int temp = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - temp >= mid) {
				ret++;
				temp = arr[i];
				if (ret == C) {
					return true;
				}
			}
		}
		return (false);
	}
}