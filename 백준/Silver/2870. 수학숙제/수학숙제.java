

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			String temp = "";
			for (char c : s) {
				if (c < 'a') {
					temp += c;
				} else {
					if (temp.equals("")) continue;
					while (temp.length() > 1 && temp.startsWith("0")) {
						temp = temp.substring(1);
					}
					
					list.add(temp);
					temp = "";
				}
			}
			if (temp.equals("")) continue;
			while (temp.length() > 1 && temp.startsWith("0")) {
				temp = temp.substring(1);
			}
			list.add(temp);
			
		}
		
		Collections.sort(list, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());
		for (String c : list) {
			System.out.println(c);
		}
	}
}
