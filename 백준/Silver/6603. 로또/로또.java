import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] a;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			a = new int[n];
			numbers = new int[6];
			if(n == 0) break;
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			go(0, 0);
			System.out.println();
			
		}
	} // main
	static void go(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(a[numbers[i]] + " ");
			}System.out.println();
			return;
		}
		for(int i=start; i<n; i++) {
			numbers[cnt] = i;
			go(cnt+1, i+1);
		}
	}
} // class