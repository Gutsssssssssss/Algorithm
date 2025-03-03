import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		List<Integer> list = new ArrayList<>();
		
		Map<Integer, Node> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] -= 1;
			list.add(arr[i]);
			if (!map.containsKey(arr[i])) {
				Node node = new Node();
				node.num = arr[i];
				node.cnt = 1;
				node.first = i;
				map.put(arr[i], node);
			} else {
				map.get(arr[i]).cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(list, (a, b) -> {
			if (map.get(a).cnt == map.get(b).cnt) {
				return map.get(a).first - map.get(b).first;
			}
			return map.get(b).cnt - map.get(a).cnt;
		});
		for (int n : list) {
			sb.append(n + 1).append(" ");
		}
		System.out.println(sb);
	} // main
	
	static class Node implements Comparable<Node> {
		int num;
		int cnt;
		int first;
		
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				return this.first - o.first;
			}
			return o.cnt - this.cnt;
		}
		
	}
}