

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] psum1 = new int[N+1];
		for (int i = 0; i < N; i++) {
			psum1[i+1] = psum1[i] + Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] psum2 = new int[M+1];
		for (int i = 0; i < M; i++) {
			psum2[i+1] = psum2[i] + Integer.parseInt(st.nextToken());
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int val = T - (psum1[i] - psum1[j]);
				map.put(val, map.getOrDefault(val, 0) + 1);
			}
		}
		long cnt = 0;
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < i; j++) {
				int val = (psum2[i] - psum2[j]);
				cnt += map.getOrDefault(val, 0);
			}
		}
		System.out.println(cnt);
	} // main
}
