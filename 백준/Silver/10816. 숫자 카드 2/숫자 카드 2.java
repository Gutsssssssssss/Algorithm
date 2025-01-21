import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
			
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int val = Integer.parseInt(st.nextToken());
			sb.append(upperBound(val) - lowerBound(val)).append(" ");
		}
		System.out.println(sb);
	} // main
	static int upperBound(int val) {
		int lo = 0;
		int hi = N-1;
		
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (arr[mid] <= val) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}
	
	static int lowerBound(int val) {
		int lo = 0;
		int hi = N-1;
		
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			
			if (arr[mid] < val) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}
}