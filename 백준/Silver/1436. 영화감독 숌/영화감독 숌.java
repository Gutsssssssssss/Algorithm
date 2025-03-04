
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int i = 0;
		int cnt = 0;
		while (true) {
			i++;
			String s = "" + i;
			if (s.contains("666")) {
				cnt++;
			}
			if (cnt == N) {
				break;
			}
		}
		System.out.println(i);
	} // main
}
