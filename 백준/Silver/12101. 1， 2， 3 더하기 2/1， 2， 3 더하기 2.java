import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		list = new ArrayList<String>();
		go(0, "");
		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		if (K - 1 >= list.size()) {
			System.out.println(-1);
			return;
		}
		String s = list.get(K - 1);
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
			if (i == s.length() - 1) continue;
			System.out.print("+");
		}
	} // main
	
	static void go(int num, String cur) {
		if (num == N) {
			list.add(cur);
			return;
		}
		
		if (cur.length() > N) {
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			go(num + i, cur + i);
		}
	}
}