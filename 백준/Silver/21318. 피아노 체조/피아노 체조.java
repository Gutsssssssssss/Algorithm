import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 현재 난이도보다 다음 난이도가 낮으면 실수
	// y 번째 악보에서는 실수하지 않는다.
	static int N, Q;
	static int[] arr, fault, psum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		fault = new int[N+1];
		psum = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i >= 1; i--) {
			if (i == 1) continue;
			if (arr[i] < arr[i-1]) {
				fault[i-1] = 1;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			psum[i] = psum[i-1] + fault[i];
		}
		
		Q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			ans = psum[y] - psum[x-1];
			if (fault[y] == 1) ans--;
			System.out.println(ans);
		}
		
		
	} // main
} // class