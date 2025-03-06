

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		int mx = -1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			mx = Math.max(mx, arr[i]);
			sum += arr[i];
		}
		
		int lo = mx; int hi = sum;
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
		int temp = mid;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (temp < arr[i]) {
				temp = mid;
				cnt++;
			}
			temp -= arr[i];
		}
		return M >= cnt;
	}
}

