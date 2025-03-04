

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			if (s.equals("end")) break;
			
			int N = s.length();
			int mCnt = 0;
			int jCnt = 0;
			boolean flag1 = false;
			boolean flag2 = true;
			boolean flag3 = true;
			char prev = 'p';
			for (int i = 0; i < N; i++) {
				char cur = s.charAt(i);
				
				if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
					flag1 = true;
					mCnt++;
					jCnt = 0;
				} else {
					mCnt = 0;
					jCnt++;
				}
				
				if (mCnt == 3 || jCnt == 3) {
					flag2 = false;
					break;
				}
				
				if (i != 0 && prev == cur && !(cur == 'e' || cur == 'o')) {
					flag3 = false;
					break;
				}
				
				prev = cur;
			}
			
			if (flag1 && flag2 && flag3) {
				sb.append("<").append(s).append("> is acceptable.").append("\n");
			} else {
				sb.append("<").append(s).append("> is not acceptable.").append("\n");
			}
		}
		System.out.println(sb);
	} // main
}
