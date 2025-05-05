

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
		boolean flag = false;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] == c) flag = true;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int lo = 0;
		int hi = lo + k - 1;
		for (int i = lo; i <= hi; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int mx = -1;
		while (true) {
			int cnt = map.keySet().size();
			if (cnt >= mx) {
				mx = cnt;
				if (!map.keySet().contains(c)) mx++;
			}
			if (lo == N - 1) break;
			int s = map.get(arr[lo]);
			if (s == 1) {
				map.remove(arr[lo]);
			} else {
				map.put(arr[lo], s - 1);
			}
			lo++;
			hi = (hi + 1) % N;
			map.put(arr[hi], map.getOrDefault(arr[hi], 0) + 1);
		}
		System.out.println(mx);
	} // main
}
