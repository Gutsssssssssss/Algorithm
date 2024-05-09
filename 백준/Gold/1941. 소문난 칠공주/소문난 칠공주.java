import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 1. 25명 중에서 7명 고르기(4명 이상 다솜파)
	// 2. 7명이 연결되어 있는지 check
	static char[][] a;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int ret;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    a = new char[5][5];
	    visited = new boolean[5][5];
	    for(int i=0; i<5; i++) {
	        char[] s = br.readLine().toCharArray();
	        for(int j=0; j<5; j++) {
	            a[i][j] = s[j];
	        }
	    }
	    go(0, 0, 0);
	    System.out.println(ret);
	    
	} // main
	static boolean check() {
	    boolean[][] visited2 = new boolean[5][5];
	    int y = 0; int x = 0;
	    for(int i=0; i<5; i++) {
	        for(int j=0; j<5; j++) {
	            visited2[i][j] = visited[i][j];
	            if(visited[i][j]) {
	                y = i; x = j;
	            }
	        }
	    }
	    Queue<Pair> q = new ArrayDeque<Pair>();
	    q.add(new Pair(y, x));
	    int cnt = 1;
	    visited2[y][x] = false;
	    while(!q.isEmpty()) {
	        Pair p = q.poll();
	        for(int i=0; i<4; i++) {
	            int ny = p.y + dy[i];
	            int nx = p.x + dx[i];
	            if(ny<0 || ny>=5 || nx<0 || nx>=5) continue;
	            if(visited2[ny][nx]) {
	                q.add(new Pair(ny, nx));
	                visited2[ny][nx] = false;
	                cnt++;
	            }
	        }
	    }
	    if(cnt==7) return true;
	    else return false;
	    
	    
	}
	static class Pair {
	    int y, x;
	    public Pair(int y, int x) {
	        super();
	        this.y = y;
	        this.x = x;
	    }
	}
	static void go(int start, int cnt, int cntS) {
	    if(cnt==7) {
	        if(cntS>=4) {
	            if(check()) {
	                ret++;
	            
	            }
	        }
	        return;
	    }
	    for(int i=start; i<25; i++) {
	        int y = i / 5;
	        int x = i % 5;
	        visited[y][x] = true;
	        if(a[y][x] == 'S') {
	        	go(i+1, cnt+1, cntS+1);
	        } else go(i+1, cnt+1, cntS);
	        visited[y][x] = false;
	    }
	}
} // class