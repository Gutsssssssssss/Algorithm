import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		
		if (N[0] == '0') {
			System.out.println(0);
			return;
		}
		
		int first = N[0] - '0';
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(first));
		
		for (int i = 1; i < N.length; i++) {
			int cur = N[i] - '0';
			
			String binary = Integer.toBinaryString(cur);
			
			while (binary.length() < 3) {
				binary = "0" + binary;
			}
			sb.append(binary);
		}
		System.out.println(sb);
	} // main
} // class