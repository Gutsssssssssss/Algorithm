import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 1_000_007;
	static int N, M, C;
	static int[][] arr;
	static int[][][][] dp;
	static int[] dy = {0, 1};
	static int[] dx = {1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1][C+1][C+1];
        for (int i = 0; i < N + 1; i++) {
        	for (int ii = 0; ii < M + 1; ii++) {
        		for (int iii = 0; iii < C + 1; iii++) {
        			Arrays.fill(dp[i][ii][iii], -1);
        		}
        	}
        }
        for (int i = 1; i <= C; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= C; i++) {
        	if (arr[1][1] != 0) {
        		sb.append(go(1, 1, arr[1][1], i - 1)).append(" ");
        	} else {
        		sb.append(go(1, 1, 0, i)).append(" ");
        	}
        }
        
        System.out.println(sb);
    } // main
    
    static int go(int y, int x, int prev, int cnt) {
    	if (cnt < 0) return 0;
    	
    	if (y == N && x == M && cnt == 0) {
    		return 1;
    	}
    	if (dp[y][x][prev][cnt] != -1) {
    		return dp[y][x][prev][cnt];
    	}
    	int ret = 0;
    	for (int i = 0; i < 2; i++) {
    		int ny = y + dy[i];
    		int nx = x + dx[i];
    		if (ny < 1 || ny >= N + 1 || nx < 1 || nx >= M + 1) continue;
    		if (arr[ny][nx] != 0) {
    			if (arr[ny][nx] > prev) {
        			ret += go(ny, nx, arr[ny][nx], cnt - 1) % INF;
        		}
    		} else {
    			ret += go(ny, nx, prev, cnt) % INF;
    		}
    	}
    	
    	return dp[y][x][prev][cnt] = ret % INF;
    }
}