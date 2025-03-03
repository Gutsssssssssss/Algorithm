import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		int l = 0;
		int r = l + M;
		int sum = 0;
		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (l < temp && temp <= r) {
				continue;
			} else if (r < temp) {
				sum += (temp - r);
				r = temp;
				l = r - M;
			} else if (l >= temp) {
				sum += (l - (temp - 1));
				l = temp - 1;
				r = l + M;
			}
			
		}
		System.out.println(sum);
	} // main
}