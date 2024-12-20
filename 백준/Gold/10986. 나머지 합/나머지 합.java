import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] psum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		psum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
			psum[i] %= M;
		}
		
		long[] cnt = new long[M];
		for (int i = 0; i <= N; i++) {
			cnt[psum[i]]++;
		}
		long sum = 0;
		for (int i = 0; i < M; i++) {
			if (cnt[i] > 1) {
				sum += (cnt[i] * (cnt[i]-1)) / 2;
			}
		}
		System.out.println(sum);
	} // main
} // class