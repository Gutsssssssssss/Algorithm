import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			list.add(new int[] {pay, day});
		}
		
		Collections.sort(list, (a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(b[0], a[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int[] cur : list) {
			if (pq.size() < cur[1]) {
				pq.add(cur[0]);
			} else if (!pq.isEmpty() && pq.peek() < cur[0]) {
				pq.poll();
				pq.add(cur[0]);
			}
		}
		
		int sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
 	} // main
}