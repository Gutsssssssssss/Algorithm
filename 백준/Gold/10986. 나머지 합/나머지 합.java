import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long[] psum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		psum = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
			psum[i] %= M;
		}
		
		long sum = 0;
		Map<Long, Long> map = new HashMap<Long, Long>();
		map.put(0L, 1L);
		for (int i = 1; i <= N; i++) {
			Long ans = map.getOrDefault((Long) psum[i], 0L);
			sum += ans;

			map.put(psum[i], ans+1);
		}
		System.out.println(sum);
	} // main
} // class