import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < N; k++) {
			char[] s = br.readLine().toCharArray();
			Stack<Character> stk = new Stack<>();
			for (char c : s) {
				if (c == '(') {
					stk.add(c);
				} else {
					if (!stk.isEmpty() && stk.peek() == '(') {
						stk.pop();
					} else {
						stk.add(c);
					}
				}
			}
			if (stk.isEmpty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	} // main
}
