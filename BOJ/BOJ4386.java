package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4386 {

	static int n;
	static double[][] a;
	static int parents[];
	static PriorityQueue<Line> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new double[n][2];
		parents = new int[n];
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Double.parseDouble(st.nextToken());
			a[i][1] = Double.parseDouble(st.nextToken());
		}
		pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				double dist = getDist(i, j);
				pq.add(new Line(i, j, dist));
			}
		}
		double ret = 0;
		while(!pq.isEmpty()) {
			Line l = pq.poll();
			if(union(l.x, l.y)) continue;
			ret += l.dist;
		}System.out.printf("%.2f", ret);
	} // main
	static int find(int i) {
		if(i==parents[i]) return i;
		return parents[i] = find(parents[i]);
	}
	static boolean union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		if(parentI == parentJ) return true;
		parents[parentJ] = parentI;
		return false;
	}
	static double getDist(int i, int j) {
		double ret = 0;
		double x = Math.pow(Math.abs(a[i][0] - a[j][0]), 2);
		double y = Math.pow(Math.abs(a[i][1] - a[j][1]), 2);
		ret = Math.sqrt(x+y);
		return ret;
	}
	static class Line implements Comparable<Line>{
		int y, x;
		double dist;
		public Line(int y, int x, double dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
		@Override
		public int compareTo(Line o) {
			return Double.compare(this.dist, o.dist);
		}
	}
} // class
