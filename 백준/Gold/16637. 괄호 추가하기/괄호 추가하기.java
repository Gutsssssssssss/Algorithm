
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer> arr;
	static List<Character> op;
	static long ret = Long.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		M = N / 2;
		op = new ArrayList<Character>();
		arr = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (i % 2 != 0) {
				op.add(s.charAt(i));
			} else {
				
				arr.add(s.charAt(i) - '0');
			}
		}
		go(0, arr.get(0));
		System.out.println(ret);
		
	} // main
	
	static void go(int idx, long sum) {
		if (idx == M) {
			ret = Math.max(ret, sum);
			return;
		}
		
		go(idx + 1, calc(sum, idx, arr.get(idx + 1)));
		if (idx + 2 <= M) {
			long temp = calc(arr.get(idx + 1), idx + 1, arr.get(idx + 2));
			go(idx + 2, calc(sum, idx, temp));
		}
	}
	static long calc(long a, int idx, long b) {
		if (op.get(idx) == '+') {
			return a + b;
		} else if (op.get(idx) == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}
