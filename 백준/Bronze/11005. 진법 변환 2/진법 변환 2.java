import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		// B가 2일 때? 
		while (N >= B) {
			int mod = N % B;
			N /= B;
			if (mod >= 10) {
				mod -= 10;
				char temp = (char) ('A' + mod);
				sb.append(temp);
			} else {
				sb.append(mod);
			}
		}
		
		if (N >= 10) {
			N -= 10;
			char temp = (char) ('A' + N);
			sb.append(temp);
		} else {
			sb.append(N);
		}
		sb.reverse();
		System.out.println(sb);
	} // main
}