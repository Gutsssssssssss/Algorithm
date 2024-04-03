package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {

	static int n;
	static int[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int l=0, r=n-1;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int ret_l=0; int ret_r=0;
		while(l<r) {
			sum = a[l] + a[r];
			if(Math.abs(sum)<min) {
				min = sum;
				ret_l=l;
				ret_r=r;
			}
			if(sum<0) l++;
			else if(sum>=0) r--;
		}
		System.out.println(a[ret_l] + " " + a[ret_r]);
	} // main
} // end
