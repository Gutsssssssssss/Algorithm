package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BOJ1806 {

	static int n, m, ret=Integer.MAX_VALUE;
	static int[] a, psum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		psum = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			psum[i+1] = psum[i] + a[i];
		}
		int r = 1;
		int l = 0;
		while( l<r) {
			if(psum[r]-psum[l]<m) r++;
			else if(psum[r]-psum[l]>=m) {
				ret = Math.min(ret, r-l);
				l++;
			}
			if(r==n+1) 
				{
					
					break;
				}
		}
		System.out.println(ret==Integer.MAX_VALUE?0:ret);
	}
}
