

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] arr = new char[H][W];
		
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int[][] ans = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(ans[i], -1);
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] == 'c') {
					int val = 0;
					ans[i][j] = val++;
					j += 1;
					while (true) {
						if (j < W && arr[i][j] != 'c') {
							ans[i][j++] = val++;
						} else if (j < W && arr[i][j] == 'c') {
							j-= 1;
							break;
						} else {
							break;
						}
					} 
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(ans[i][j] + " ");
			}System.out.println();
		}
	} // main
}
