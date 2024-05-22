import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 가장 왼쪽 계란부터 들고, 다른 계란을 친다. 손에 든 계란이 깨지거나 칠 계란이 없으면 넘어간다.
	// 이후 원래 자리에 놓고 다음 계란을 들고 반복한다.
	// 계란을 드는 과정은 순서대로지만 계란을 깨는 과정을 순서가 없다. -> 순열
	// 상대 계란의 무게 만큼 내구도가 깎임
	// 2차원배열로 계란 정보[내구도, 무게]
	// 배열을 인자로 넘기면서 각 경우마다 계란 정보 유지
	// visited처리
	// 종료 조건: idx==n일때
	static int n, ret=-1;
	static int[][] egg;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		egg = new int[n][2];
		boolean[] visited = new boolean[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		go(0, 0);
		System.out.println(ret);
	} // main
	
	static void go(int now, int cnt) {
		ret = Math.max(cnt, ret);
		if(now == n) {
			return;
		}
		if(egg[now][0] <= 0) go(now+1, cnt);
		else {
			for(int i=0; i<n; i++) {
				if(i==now || egg[i][0] <= 0) continue;
				egg[i][0] -= egg[now][1];
				egg[now][0] -= egg[i][1];
				int broken = cnt;
				if(egg[i][0]<=0) broken++;
				if(egg[now][0]<=0) broken++;
				go(now+1, broken);
				egg[i][0] += egg[now][1];
				egg[now][0] += egg[i][1];
			}
		}
	}
} // class