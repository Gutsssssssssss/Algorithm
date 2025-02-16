import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, C;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Long> list1 = new ArrayList<>();
		List<Long> list2 = new ArrayList<>();
		
	
 		go(0, N / 2, list1, 0);
 		go(N / 2, N, list2, 0);

		
		Collections.sort(list1);
		Collections.sort(list2);
		
		long sum = 0;
		for (long cur : list1) {
			if (cur > C) continue;
			sum += upperbound(list2, (C - cur));
		}
		System.out.println(sum);
	} // main
	static int upperbound(List<Long> list, long val) {
		int lo = 0;
		int hi = list.size() - 1;
		
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (val >= list.get(mid)) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}
	static void go(int start, int end, List<Long> list, long sum) {
		if (start == end) {
			list.add(sum);
			return;
		}
		
		go(start + 1, end, list, sum + arr[start]);
		go(start + 1, end, list, sum);
	}
}