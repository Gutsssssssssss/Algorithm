
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		int[] cnt = new int[d+1];
		int lo = 0;
		int hi = lo + k - 1;
		int len = 0;
		for (int i = lo; i <= hi; i++) {
			if (cnt[arr[i]] == 0) len++;
			cnt[arr[i]]++;
		}
		int mx = -1;
		while (true) {
			if (len >= mx) {
				mx = len;
				if (cnt[c] == 0) mx++;
			}
			if (lo == N - 1) break;
			cnt[arr[lo]]--;
			if (cnt[arr[lo]] == 0) len--;
			lo++;
			hi = (hi + 1) % N;
			if (cnt[arr[hi]] == 0) len++;
			cnt[arr[hi]]++;
		}
		System.out.println(mx);
	} // main
}
