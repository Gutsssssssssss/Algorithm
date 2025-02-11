import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		
		int y = N / 2;
		int x = N / 2;
		arr[y][x] = 1;
		int dir = 0;
		int size = 1;
		int num = 2;
		
		while (true) {
			if (y == 0 && x == 0) {
				break;
			}
			boolean flag = false;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < size; j++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					arr[ny][nx] = num;
					if (ny == 0 && nx == 0) {
						flag = true;
						break;
					}
					num++;
					y = ny;
					x = nx;
				}
				if (flag) {
					break;
				}
				dir = (dir + 1) % 4;
			}
			if (flag) {
				break;
			}
			size++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == M) {
					sb.append((i+1) + " " + (j+1));
				}
			}
		}
		System.out.println(sb);
	} // main
}