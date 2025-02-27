import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int A, B, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(go(B));
	} // main
	
	static long go(int num) {
		if (num == 1) return A % C;
		
		long ret = go(num / 2);
		ret = ret*ret % C;
		if (num % 2 == 1) ret *= A % C;
		
		
		return ret % C;
	}
}