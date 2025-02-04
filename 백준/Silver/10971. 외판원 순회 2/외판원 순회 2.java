import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	static final int INF = Integer.MAX_VALUE / 2;
	static int N;
	static int[][] W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = go(1, 0);
		System.out.println(ans);
	} // main
	
	static int go(int visited, int here) {
		if (visited == (1 << N) - 1) {
			return W[here][0] == 0 ? INF : W[here][0];
		}
		
		int ret = INF;
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0) continue;
			if (W[here][i] == 0) continue;
			ret = Math.min(ret, go(visited | (1 << i), i) + W[here][i]);
		}
		return ret;
	}
}