import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] check;
	static double A, B;
	static double[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine()) / 100.0;
		B = Integer.parseInt(br.readLine()) / 100.0;
		check = new boolean[21];
		dp = new double[21][21][21];
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				Arrays.fill(dp[i][j], -1.0);
			}
		}
		era();
		System.out.printf("%.7f", go(0, 0, 0));
	} // main
	
	static double go(int y, int x, int cnt) {
		if (cnt == 18) {
			return (check[y] || check[x]) ? 1.0 : 0.0;
		}
		
		if (dp[y][x][cnt] > -0.5) {
			return dp[y][x][cnt];
		}
		double ret = 0.0;
		
		ret += go(y + 1, x, cnt + 1) * (A * (1 - B));
		ret += go(y, x + 1, cnt + 1) * ((1 - A) * B);
		ret += go(y + 1, x + 1, cnt + 1) * (A * B);
		ret += go(y, x, cnt + 1) * ((1 - A) * (1 - B));
		return dp[y][x][cnt] = ret;
	}
	
	static void era() {
		Arrays.fill(check, true);
		check[0] = false;
		check[1] = false;
		for (int i = 2; i <= 20; i++) {
			if (check[i]) {
				for (int j = i + i; j <= 20; j += i) {
					check[j] = false;
				}
			}
		}
	}
}