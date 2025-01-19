import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, ret;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		int lo = 1; int hi = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hi = Math.max(hi, arr[i]);
		}
		
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			
			if (check(mid)) {
				ret = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ret);
	} // main
	static boolean check(int mid) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			int cur = arr[i];
			sum += (cur - mid) > 0 ? (cur - mid) : 0;
		}
		return sum >= M;
	}
}