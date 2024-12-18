import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] psum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		psum = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			psum[i] = psum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			int ans = map.getOrDefault(psum[i] - K, 0);
			// 현재 값 넣기, 있으면 ++ 없으면 1
			map.put(psum[i], map.getOrDefault(psum[i], 0) + 1);
			sum += ans;
		}
		System.out.println(sum);
	} // main
} // class