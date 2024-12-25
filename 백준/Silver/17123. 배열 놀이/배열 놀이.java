import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N+1][N+1];
			int[][] diff = new int[N+2][N+2];
			int[][] psum = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int si = Integer.parseInt(st.nextToken());
				int sj = Integer.parseInt(st.nextToken());
				int ei = Integer.parseInt(st.nextToken());
				int ej = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				diff[si][sj] += v;
				diff[si][ej+1] -= v;
				diff[ei+1][sj] -= v;
				diff[ei+1][ej+1] += v;
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + diff[i][j];
					arr[i][j] += psum[i][j];
				}
			}
			int[][] ans = new int[2][N+1]; // 0: 행합
			for (int i = 1; i <= N; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 1; j <= N; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}
				ans[0][i] = rowSum;
				ans[1][i] = colSum;
			}
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(ans[i][j]).append(" ");
				}sb.append("\n");
			}
		} // TC
		System.out.println(sb);
	} // main
} // class