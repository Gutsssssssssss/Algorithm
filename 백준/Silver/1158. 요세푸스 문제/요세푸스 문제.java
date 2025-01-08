import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append("<");
		while(!q.isEmpty()) {
			for (int i = 0; i < K; i++) {
				int a = q.poll();
				if (i == K - 1) {
					sb.append(a).append(", ");
					break;
				}
				q.add(a);
			}
		}
		sb.replace(sb.length() - 2, sb.length(), ">");
		System.out.println(sb);
	}
}