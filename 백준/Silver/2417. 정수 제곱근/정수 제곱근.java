import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long start = 0;
		long end = n;
		long ret = 0;
		while (start <= end) {
			long mid = (start + end) >>> 1;

			if (Math.pow(mid, 2) >= n) {
				ret = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			} 
		}
		System.out.println(ret);
	} // main
}