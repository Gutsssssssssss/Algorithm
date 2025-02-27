import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static List<int[]> wallList, virusList;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		wallList = new ArrayList<int[]>();
		virusList = new ArrayList<int[]>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					wallList.add(new int[] {i, j});
				} else if (arr[i][j] == 2) {
					virusList.add(new int[] {i , j});
				}
			}
		}
		int size = wallList.size();
		
		int mx = -1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				for (int k = 0; k < j; k++) {
					visited = new boolean[N][M];
					arr[wallList.get(i)[0]][wallList.get(i)[1]] = 1;
					arr[wallList.get(j)[0]][wallList.get(j)[1]] = 1;
					arr[wallList.get(k)[0]][wallList.get(k)[1]] = 1;
					mx = Math.max(mx, solve());
					arr[wallList.get(i)[0]][wallList.get(i)[1]] = 0;
					arr[wallList.get(j)[0]][wallList.get(j)[1]] = 0;
					arr[wallList.get(k)[0]][wallList.get(k)[1]] = 0;
				}
			}
		}
		System.out.println(mx);
	} // main
	static int solve() {
		int size = virusList.size();
		for (int i = 0; i < size; i++) {
			dfs(virusList.get(i)[0], virusList.get(i)[1]);
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 && !visited[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static void dfs (int y, int x) {
		visited[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M || arr[ny][nx] == 1 || visited[ny][nx]) continue;
			dfs(ny, nx);
		}
	}
}