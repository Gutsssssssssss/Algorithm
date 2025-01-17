import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		long start = 1; long end = S;
		long ret = 0;
		while (start <= end) {
			long mid = (end + start) >>> 1;
			
			long sum = (mid + 1) * mid / 2;
//			System.out.println(sum);
//			System.out.println(mid);
//			System.out.println();
			
			if (sum == S) {
				ret = mid;
				break;
			} else if (sum < S) {
				start = mid + 1;
				ret = Math.max(ret, mid);
			} else if (sum > S) {
				end = mid - 1;
			}
		}
		System.out.println(ret);
	} // main
}