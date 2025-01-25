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
		
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int lo = 1; int hi = arr[N] - arr[1];
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
		int cnt = 1;
		int temp = arr[1];
		for (int i = 2; i <= N; i++) {
			if (temp + mid <= arr[i]) {
				cnt++;
				temp = arr[i];
		
			}
		}
		return cnt >= C;
	}
}