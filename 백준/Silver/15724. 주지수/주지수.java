import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] psum = new long[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			long sum = psum[x2][y2] - psum[x1-1][y2] - psum[x2][y1-1] + psum[x1-1][y1-1];
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	} // main
}