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
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int hi = 0;
		int mx = -1;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hi += arr[i];
			mx = Math.max(mx, arr[i]);
		}
		
		int lo = mx; 
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
		for (int i = 1; i <= N; i++) {
			if (temp - arr[i] < 0) {
				cnt++;
				temp = mid;
			}
			temp -= arr[i];
		}
		return cnt <= M;
	}
}