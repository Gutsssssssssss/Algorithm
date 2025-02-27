import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int N, S, E;
	static int[] arr;
	static List<List<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		N = (int)Math.pow(2, K) - 1;
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<List<Integer>>();
		for (int i = 0; i <= K; i++) {
			list.add(new ArrayList<>());
		}
		
		go(0, N - 1, 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= K; i++) {
			for (Integer j : list.get(i)) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	} // main
	
	static void go(int s, int e, int level) {
		if (s > e) return;
		int mid = (s + e) >>> 1;
		list.get(level).add(arr[mid]);
		go(s, mid - 1, level + 1);
		go(mid + 1, e, level + 1);
	}
}