import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= N - 1; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
		int mx = -1;
		int idx = -1;
		for (int i = 1; i <= N; i++) {
			if (dp[i] > mx) {
				mx = dp[i];
				idx = i;
			}
		}
		System.out.println(mx);
		int cnt = mx;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = N; i >= 1; i--) {
			if (dp[i] == cnt) {
				list.add(arr[i]);
				cnt--;
			}
		}
		Collections.sort(list);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.print(list.get(i) + " ");
		}
	} // main
	
}