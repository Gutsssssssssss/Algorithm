import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int u = upperBound(s);
			int l = lowerBound(e);
//			System.out.println(u);
//			System.out.println(l);
//			System.out.println();
			
			System.out.println(l - u);
		}
	} // main
	
	// cur보다 작은 가장 큰 idx
	static int upperBound(int cur) {
		int lo = 1; int hi = N;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (cur <= arr[mid]) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	// cur보다 같거나 작은 가장 큰 idx
	static int lowerBound(int cur) {
		int lo = 1; int hi = N;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			
			if (cur >= arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return hi + 1;
	}
}