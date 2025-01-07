import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(1);
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int prev = arr[1];
		int mxU = -1; int mxL = -1;
		int uCnt = 1; int lCnt = 1;
		for (int i = 2; i <= N; i++) {
			if (arr[i] > prev) {
				uCnt++;
				lCnt = 1;
				mxU = Math.max(uCnt, mxU);
			}
			if (arr[i] < prev) {
				lCnt++;
				uCnt = 1;
				mxL = Math.max(lCnt, mxL);
			}
			if (arr[i] == prev) {
				lCnt++;
				uCnt++;
				mxL = Math.max(lCnt, mxL);
				mxU = Math.max(uCnt, mxU);
				
			}
			prev = arr[i];
		}
		System.out.println(Math.max(mxU, mxL));
		
	} // main
}