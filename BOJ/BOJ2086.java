package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2086 {

	static long a, b;
	static final int MOD = 1_000_000_000;
	static long[][] A = {
			{1, 1},
			{1, 0}
	};
	static long[][] B = {
			{1, 1},
			{1, 0}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		System.out.println((pow(B, b+1)[0][0]%MOD-pow(A, a)[0][0]%MOD + MOD)%MOD);
	} // end of main
	static long[][] pow(long[][] arr, long m) {
		if(m==1) return arr;
		long[][] ret = pow(arr, m/2);
		ret = mult(ret, ret);
		if(m%2!=0) ret = mult(ret, A);
		return ret;
	}
	static long[][] mult(long[][] arr, long[][] brr) {
		long[][] ret = new long[2][2];
		for(int i=0;i<2; i++) {
			for(int j=0;j<2; j++) {
				for(int k=0;k<2;k++) {
					ret[i][j] += arr[i][k]*brr[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
} // end of class
