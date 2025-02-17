import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][4];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
			// 0: 도보 시간, 1: 도보 금액, 2: 자전거 시간, 3: 자전거 금액 
		}
		
		System.out.println(go(0, K));
	} // main
	
	static int go(int here, int time) {
		
		if (time < 0) return -Integer.MAX_VALUE / 2;
		
		if (here == N) {
			return 0;
		}
		
		int ret = -Integer.MAX_VALUE / 2;
		ret = Math.max(ret, go(here + 1, time - arr[here+1][0]) + arr[here+1][1]);
		
		ret = Math.max(ret, go(here + 1, time - arr[here+1][2]) + arr[here+1][3]);
		
		return ret;
	}
}