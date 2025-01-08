import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int ret;
	static ArrayList<Integer> aList, bList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		aList = new ArrayList<Integer>();
		bList = new ArrayList<Integer>();
		int N = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			aList.add(a);
			bList.add(b);
		}
		
		N = aList.size();
		
		int[][][] dp = new int[N+1][16][16];
		
		for (int i = 1; i <= N; i++) {
			
			for (int w = 0; w <= 15; w++) {
				for (int b = 0; b <= 15; b++) {
					
					dp[i][w][b] = Math.max(dp[i][w][b], dp[i-1][w][b]);
					
					if (w < 15) {
						dp[i][w+1][b] = Math.max(dp[i][w+1][b], dp[i-1][w][b] + aList.get(i-1));
					}
					
					if (b < 15) {
						dp[i][w][b+1] = Math.max(dp[i][w][b+1], dp[i-1][w][b] + bList.get(i-1));
					}
				}
			}
		}
		
		System.out.println(dp[N][15][15]);
	} // main
	
}