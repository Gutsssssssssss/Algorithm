package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ3055 {

	static int n, m, sy, sx, ret, ey, ex;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static char[][] a;
	static int[][] visited_go, visited_wa;
	static Queue<Pair> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited_go = new int[n][m];
		visited_wa = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(visited_wa[i], Integer.MAX_VALUE);
		}
		a = new char[n][m];
		for(int i=0; i<n; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				a[i][j] = c[j];
				if(c[j] == '*') {
					q.add(new Pair(i, j));
					visited_wa[i][j] = 1;
				} else if(a[i][j]=='S') {
					sy = i; sx = j;
				} else if(a[i][j] == 'D') {
					ey= i; ex = j;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(ny<0 || ny>=n || nx<0 || nx>=m || visited_wa[ny][nx] !=Integer.MAX_VALUE || a[ny][nx] == 'X' || a[ny][nx] == 'D') continue;
				visited_wa[ny][nx] = visited_wa[cur.y][cur.x] + 1;
				q.add(new Pair(ny, nx));
			}
		}
		
		visited_go[sy][sx] = 1;
		q.add(new Pair(sy, sx));
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			if(a[cur.y][cur.x] == 'D') {
				ret = visited_go[cur.y][cur.x];
			}
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(ny<0 || ny>=n || nx<0 || nx>=m || visited_go[ny][nx] !=0 || a[ny][nx] == 'X') continue;
				if(visited_go[cur.y][cur.x] + 1< visited_wa[ny][nx] || (ny==ey&&nx==ex)) {
					visited_go[ny][nx] = visited_go[cur.y][cur.x] + 1;
					q.add(new Pair(ny, nx));
				}
			}
		}
		
		if(ret==0) {
			System.out.println("KAKTUS");
		} else System.out.println(ret-1);
		
		
	} // end of main
	static class Pair {
		int y, x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
} // end of class
