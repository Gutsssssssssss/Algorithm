package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {

	static int n;
	static long m;
	static int[][] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		a = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		int temp[][] = go(a, m);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(temp[i][j] + " ");
			}System.out.println();
		}
	} // end of main
	static int[][] go(int[][] arr, long m) {
		if(m==1) return arr;
		int[][] ret = go(arr, m/2);
		ret = mult(ret, ret);
		if(m%2 != 0) {
			ret = mult(ret, arr);
		}
		return ret;
	}
	
	static int[][] mult(int[][] arr, int[][] brr) {
		int[][] ret = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					ret[i][j] += arr[i][k]*brr[k][j];
					ret [i][j] %= 1000;
				}
			}
		}
		return ret;
	}
} // end of class
