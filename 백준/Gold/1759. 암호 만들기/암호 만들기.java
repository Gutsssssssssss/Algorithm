import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 순서 없이 n개 뽑기 -> 조합
	// 최소 1개의 모음과 2개의 자음이 있어야 한다.
	static int n, m;
	static String[] a;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = new String[m];
		for(int i=0; i<m; i++) {
			a[i] = st.nextToken();
		}
		Arrays.sort(a);
		numbers = new int[n];
		go(0, 0);
		System.out.println(sb);
	}
	static void go(int cnt, int start) {
		if(cnt==n) {
			String s = "";
			for(int i=0; i<n; i++) {
				s += a[numbers[i]];
			}
			if(check(s)) {
				sb.append(s).append("\n");
			}
			return;
		}
		for(int i=start; i<m; i++) {
			numbers[cnt] = i;
			go(cnt+1, i+1);
		}
	}
	static boolean check(String s) {
		int lcnt = 0;
		int vcnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
					|| s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				lcnt++;
			} else {
				vcnt++;
			}
		}
		if(lcnt>=1 && vcnt>=2) return true;
		return false;
	}
}