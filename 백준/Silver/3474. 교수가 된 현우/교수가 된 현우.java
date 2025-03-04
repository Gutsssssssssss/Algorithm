

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for (int i = 5; i <= N; i*=5) {
				sum += (N / i);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	} // main
}
