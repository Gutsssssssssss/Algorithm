

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			char[] s = br.readLine().toCharArray();
			if (s.length == 1 && s[0] == '.') break;
			Stack<Character> stk = new Stack<>();
			for (char c : s) {
				if (c == '(' || c == '[') {
					stk.add(c);
				} else {
					if (!stk.isEmpty() && stk.peek() == '(' && c == ')') {
						stk.pop();
					} else if (!stk.isEmpty() && stk.peek() == '[' && c == ']' ) {
						stk.pop();
					} else if (c == ')' || c == ']'){
						stk.add(c);
					}
				}
			}
			if (stk.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);
	} // main
}
