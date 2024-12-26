import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = fibo(N);
		System.out.println(ans);
	} // main
	
	static int fibo(int n) {
		if (n == 0) return 0;
		if (n == 1 || n == 2) return 1;
		return fibo(n - 1) + fibo(n - 2);
	}
}