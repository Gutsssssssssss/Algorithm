import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE / 2;
	static List<Integer> arr;
	static int[][] power;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new ArrayList<Integer>();
		power = new int[5][5];
		for (int i = 1; i <= 4; i++) {
			power[0][i] = 2;
		}
		for (int i = 1; i <= 4; i++) {
			power[i][i] = 1;
		}
		power[1][2] = 3; power[1][4] = 3;
		power[2][1] = 3; power[2][3] = 3;
		power[3][2] = 3; power[3][4] = 3;
		power[4][3] = 3; power[4][1] = 3;
		power[1][3] = 4; power[2][4] = 4; power[3][1] = 4; power[4][2] = 4;
		
		while (true) {
			int N = Integer.parseInt(st.nextToken());
			arr.add(N);
			if (N == 0) break;
		}
		dp = new int[5][5][arr.size() + 1];
		for (int i = 0; i <= 4; i++) {
			for (int ii = 0; ii <= 4; ii++) {
				Arrays.fill(dp[i][ii], -1);
			}
		}
		System.out.println(go(0, 0, 0));
	} // main
	
	static int go(int x, int y, int idx) {
		int next = arr.get(idx);
		if (next == 0) return 0;
		if (!(x == 0 && y == 0) && x == y) return INF;
		
		if (dp[x][y][idx] != -1) return dp[x][y][idx];
		int ret = INF;
		ret = Math.min(ret, go(next, y, idx + 1) + power[x][next]);
		ret = Math.min(ret, go(x, next, idx + 1) + power[y][next]);
		
		return dp[x][y][idx] = ret;
	}
}