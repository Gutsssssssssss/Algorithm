import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(go(0, 0, N));
	} // main
	static String go(int y, int x, int size) {
		int start = arr[y][x];
		if (size == 1) {
			return start + "";
		}
		boolean flag = false;
		String ret = "";
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (start != arr[i][j]) {
					flag = true;
					ret += "(";
					ret += go(y, x, size / 2);
					ret += go(y, x + size / 2, size / 2);
					ret += go(y + size / 2, x, size / 2);
					ret += go(y + size / 2, x + size / 2, size / 2);
					ret += ")";
					return ret;
				}
			}
		}
		if (!flag) {
			ret += start + "";
		}
		return ret;
	}
	
	
}