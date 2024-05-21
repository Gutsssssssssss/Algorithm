import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// n = 3*2^k, 28일 때는 k가 3
	// 출력 별은 세로로 n줄 
	// k=0일 때 기본 삼각형, k가 1일 때 k-1의 삼각형이 3개 합쳐진 형태
	// 기저 조건에서 삼각형을 그리
	static int n;
	static char[][] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new char[n][n*2-1];
		for(int i=0; i<n; i++) {
			Arrays.fill(a[i], ' ');
		}
		go(0, n-1, n);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n*2-1; j++) {
				sb.append(a[i][j]);
			}sb.append("\n");
		}
		System.out.println(sb);
	}
	static void go(int y, int x, int size) {
		if(size==3) {
			a[y][x] = '*';
			a[y+1][x-1] = a[y+1][x+1] = '*';
			a[y+2][x-2] = a[y+2][x-1] = a[y+2][x] = a[y+2][x+1] = a[y+2][x+2] = '*';
			return;
		}
		int newSize = size / 2;
		go(y, x, newSize);
		go(y+newSize, x-newSize, newSize);
		go(y+newSize, x+newSize, newSize);
	}
}