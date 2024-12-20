import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] psum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		psum = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(psum[x][y] - psum[i-1][y] - psum[x][j-1] + psum[i-1][j-1]).append("\n");
		}
		System.out.println(sb);
	} // main
} // class