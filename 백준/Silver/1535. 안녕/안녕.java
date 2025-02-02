import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] hpArr, joyArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hpArr = new int[N+1];
		joyArr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			hpArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			joyArr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Math.max(go(100 - hpArr[1], 1, 1), go(100, 1, 0)));
	} // main
	static int go(int hp, int idx, int flag) {
		if (hp <= 0) return -1;
		
		if (idx == N) {
			return flag == 1 ? joyArr[idx] : 0;
		}
		if (idx + 1 > N) return -1;

		int ret = Math.max(go(hp - hpArr[idx+1], idx + 1, 1), go(hp, idx + 1, 0)) + (flag == 1 ? joyArr[idx] : 0);
		
		return ret;
	}
}