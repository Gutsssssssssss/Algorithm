import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int mni, mnj, mxi, mxj;
	static long[][] psum;
	static long mn=Long.MAX_VALUE, mx=Long.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		psum = new long[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + Long.parseLong(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int ii = 1; ii <= i; ii++) {
					for (int jj =1; jj <= j; jj++) {
						mx = Math.max(mx, psum[i][j] - psum[ii-1][j] - psum[i][jj-1] + psum[ii-1][jj-1]);
					}
				}
			}
		}
		System.out.println(mx);
	} // main
} // min