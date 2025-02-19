import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			});
		}
		
		Collections.sort(list, (a, b) -> a[0] - b[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int[] cur : list) {
			int cd = cur[0];
			int cp = cur[1];
			
			if (cd > pq.size()) {
				pq.add(cp);
			} else if (cp > pq.peek()) {
				pq.poll();
				pq.add(cp);
			}
		}
		
		int sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	} // main
}