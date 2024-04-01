package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16134 {
	
	static int T, n, r;
	static final int P = 1_000_000_007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		long first = factorial(n) % P;
		long second = go((factorial(r)%P)*(factorial(n-r)%P)%P, P-2);
		System.out.println((first*second)%P );
	}
	static long go(long a, long b) {
		if(b == 1) return a % P;
		long ret = go(a, b/2);
		ret = (ret*ret) % P;
		if(b%2!=0) ret = (ret*a) % P;
		return ret;
	}
	
	static long factorial(int num) {
		long ret = 1;
		for(int i=1;i<=num; i++) {
			ret *= i;
			ret %= P;
		}
		return ret;
	}
}
