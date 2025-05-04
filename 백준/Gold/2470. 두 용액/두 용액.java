
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int lo = 0; int hi = N - 1;
		int mn = 2000000001;
		int ans1 = 0;
		int ans2 = 0;
		while (lo < hi) {
			int sum = arr[lo] + arr[hi];
			if (Math.abs(sum) < mn) {
				mn = Math.abs(sum);
				ans1 = arr[lo];
				ans2 = arr[hi];
			}
			if (sum < 0) {
				lo++;
			} else {
				hi--;
			}
		}
		System.out.println(ans1 + " " + ans2);
	} // main
}
