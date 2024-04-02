package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9252 {

	static char[] a, b;
	static int n, m, ret=-1;
	static int[][] LCS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		n = a.length;
		m = b.length;
		LCS = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(a[i-1]==b[j-1]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				} else if(a[i-1] != b[j-1]) {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
				ret = Math.max(ret, LCS[i][j]);
			}
		}
		StringBuilder res = new StringBuilder();
		int i=n; int j=m;
		while(true) {
			if(LCS[i][j] == 0) break;
			if(LCS[i][j] == LCS[i-1][j]) {
				i = i-1;
			} else if(LCS[i][j] == LCS[i][j-1]) {
				j = j-1;
			} else {
				res.append(a[i-1]);
				i = i-1;
				j = j-1;
			}
		}
		res = res.reverse();
		System.out.println(ret);
		System.out.println(res);
	}
}
