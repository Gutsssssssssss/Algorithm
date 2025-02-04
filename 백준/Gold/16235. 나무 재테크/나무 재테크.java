import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int[][] A, yang;
	static PriorityQueue<Tree> pq;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		yang = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				yang[i][j] = 5;
			}
		}
		
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			x -= 1; y -= 1;
			pq.add(new Tree(x, y, z));
		}
		
		int time = 0;
		while (time != K) {
			time++;
			springAndSpring();
			fall();
			winter();
		}
		System.out.println(pq.size());
	} // main
	
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				yang[i][j] += A[i][j];
			}
		}
	}
	
	static void fall() {
		PriorityQueue<Tree> temp = new PriorityQueue<>();
		ArrayList<int[]> posList = new ArrayList<int[]>();
		
		while (!pq.isEmpty()) {
			Tree cur = pq.poll();
			
			if (cur.age % 5 == 0) {
				posList.add(new int[] {cur.y, cur.x});
			}
			temp.add(cur);
		}
		
		pq = temp;
		
		int size = posList.size();
		for (int i = 0; i < size; i++) {
			int[] cur = posList.get(i);
			int cy = cur[0];
			int cx = cur[1];
			for (int d = 0; d < 8; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				Tree newTree = new Tree(ny, nx, 1);
				pq.add(newTree);
			}
		}
	}
	
	static void springAndSpring() {
		PriorityQueue<Tree> temp = new PriorityQueue<>();
		ArrayList<Tree> dead = new ArrayList<>();
		
		while (!pq.isEmpty()) {
			Tree cur = pq.poll();
			if (yang[cur.y][cur.x] >= cur.age) {
				yang[cur.y][cur.x] -= cur.age;
				cur.age += 1;
				temp.add(cur);
			} else {
				dead.add(cur);
			}
		}
		pq = temp;
		
		int size = dead.size();
		for (int i = 0; i < size; i++) {
			Tree cur = dead.get(i);
			int val = cur.age / 2;
			yang[cur.y][cur.x] += val;
		}
	}
	
	static class Tree implements Comparable<Tree>{
		int y;
		int x;
		int age;
		public Tree(int y, int x, int age) { 
			this.y = y;
			this.x = x;
			this.age = age;
		}
		
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
}