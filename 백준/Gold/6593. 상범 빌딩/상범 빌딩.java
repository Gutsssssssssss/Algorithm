import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int l, n, m, sz, sy, sx, ez, ey, ex;
	static int dy[] = {-1, 0, 1, 0, 0, 0};
	static int dx[] = {0, 1, 0, -1, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
	static char[][][] a;
	static int[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new char[l][n][m];
			visited = new int[l][n][m];
			if(l==0 && n==0 && m==0) break;
			for(int i=0; i<l; i++) {
				for(int j=0; j<n; j++) {
					char[] s = br.readLine().toCharArray();
					for(int k=0; k<m; k++) {
						a[i][j][k] = s[k];
						if(s[k] == 'S') {
							sz = i; sy = j; sx = k;
						} else if(s[k] == 'E') {
							ez = i; ey = j; ex = k;
						}
					}
				}
				br.readLine();
			}
			visited[sz][sy][sx] = 1;
			Queue<Pair> q = new ArrayDeque<>();
			q.add(new Pair(sz, sy, sx));
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				if(cur.z==ez && cur.y==ey && cur.x == ex) break;
				for(int i=0; i<6; i++) {
					int nz = cur.z + dz[i];
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if(ny<0 || ny>=n || nx<0 || nx>=m || nz<0 || nz>=l) continue;
					if(visited[nz][ny][nx]!=0) continue;
					if(a[nz][ny][nx] == '#') continue;
					visited[nz][ny][nx] = visited[cur.z][cur.y][cur.x] + 1;
					q.add(new Pair(nz, ny, nx));
				}
			}
			if(visited[ez][ey][ex] == 0) {
				sb.append("Trapped!\n");
			} else {
				sb.append("Escaped in ").append(visited[ez][ey][ex]-1).append(" minute(s).\n");
			}

		}
		System.out.println(sb);
	} // main
	static class Pair {
		int z, y, x;

		public Pair(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
} // class