import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int mn = arr[0];
		int mx = -100000001;
		for (int i = 1; i <= N; i++) {
			mx = Math.max(arr[i] - mn, mx);
			mn = Math.min(arr[i], mn);
		}
		System.out.println(mx);
	} // main
}