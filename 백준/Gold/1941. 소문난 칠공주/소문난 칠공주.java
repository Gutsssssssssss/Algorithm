import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int N = 5;
	static char[][] a;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static boolean[] visited;
	static int[] numbers;
	static int ret;
	// 조합으로 25개 중 연속된 7개 구하기
	// 연속된 7개가 7공주 가능한지 체크하기
	// 7공주: 다솜파
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = new char[N][N];
		numbers = new int[7];
		for(int i=0; i<N; i++) {
			char[] s = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				a[i][j] = s[j];
			}
		}
		go(0, 0);
		System.out.println(ret);
	} // main
	static boolean bfs() {
		visited[0] = true;
		Queue<Pair> q = new ArrayDeque<Pair>();
		q.add(new Pair(numbers[0]/5, numbers[0]%5));
		int cnt = 1;
		int cntS = 0;
		if(a[q.peek().y][q.peek().x] == 'S') cntS++;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				int ni = ny*5 + nx;
				if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
				for(int j=0; j<7; j++) {
					if(numbers[j] == ni && !visited[j]) {
						visited[j] = true;
						if(a[ny][nx] == 'S') cntS++;
						q.add(new Pair(ny, nx));
						cnt++;
					}
				}
			}
		}
		if(cnt==7 && cntS >= 4) return true;
		return false;
	}
	static void go(int cnt, int start) {
		if(cnt==7) {
			visited = new boolean[7];
			if(bfs()) {
				ret++;
			}
			return;
		}
		for(int i=start; i<N*N; i++) {
			numbers[cnt] = i;
			go(cnt+1, i+1);
		}
	}
	static class Pair {
		int y, x;

		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
} // class