package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11444 {

	static long n;
	static final int MOD = 1_000_000_007;
	static long[][] A = {
			{1, 1},{1, 0}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		System.out.println(go(A, n-1)[0][0]);
	}
	
	static long[][] go(long[][] arr, long m) {
		if(m==1 || m==0) return arr;
		long[][] ret = go(arr, m/2);
		ret = mult(ret, ret);
		if(m%2!=0) {
			ret = mult(ret, arr);
		}
		return ret;
	}
	
	static long[][] mult(long[][] arr, long[][] brr) {
		long[][] ret = new long[2][2];
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					ret[i][j] += arr[i][k]*brr[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
} // class
