import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while (N != 0) {
			if (N % 5 == 0) {
				N -= 5;
				cnt++;
			} else if (N % 3 == 0) {
				N -= 3;
				
				cnt++;
			} else if (N > 5) {
				N -= 5;
				cnt++;
			} else if (N == 4 || N == 1 || N == 2) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(cnt);
	} // main
}