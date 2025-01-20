import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] brr;
	static String[] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N+1];
		brr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= M; i++) {
			System.out.println(go(Integer.parseInt(br.readLine())));
		}
	} // main
	static String go(int cur) {
		int ret = 0;
		int hi = N;
		int lo = 1;
		
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (brr[mid] >= cur) {
				ret = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return arr[ret];
	}
}