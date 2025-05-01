
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int lo = 0; int hi = N - 1;
			
			while (true) {
				if (lo == i) lo++;
				else if (hi == i) hi--;
				if (lo >= hi) break;
				
				if (arr[lo] + arr[hi] < arr[i]) {
					lo++;
				} else if (arr[lo] + arr[hi] > arr[i]) {
					hi--;
				} else {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	} // main
}
