import java.util.Scanner;

public class Main {

	static int n;
	// 재귀 -> 문제를 해결하기 위해 작은 크기로 줄여서 해결해 나가는 방식
	// start, temp, end가 있으면 n-1개를 temp로 옮기고 가장 큰 1개를 end로 옮긴다.
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		go(1, 2, 3, n);
		System.out.println((1<<n)-1);
		System.out.println(sb);
	}
	static void go(int start, int temp, int end, int num) {
		
		if(num ==1 ) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		go(start, end, temp, num-1);
		sb.append(start).append(" ").append(end).append("\n");
		go(temp, start, end, num-1);
	}
}