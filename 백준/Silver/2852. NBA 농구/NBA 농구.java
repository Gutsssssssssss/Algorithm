

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int A = 0;
		int B = 0;
		int ACnt = 0;
		int BCnt = 0;
		int prev = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int time = timeToInt(st.nextToken());
			
			if (A > B) {
				ACnt += (time - prev);
			} else if (B > A) {
				BCnt += (time - prev);
			}
			
			if (num == 1) {
				A++;
			} else {
				B++;
			}
			
			prev = time;
		}
		
		if (A > B) {
			ACnt += (48*60 - prev);
		} else if (B > A) {
			BCnt += (48*60 - prev);
		}
		
		System.out.println(intToString(ACnt));
		System.out.println(intToString(BCnt));
	} // main
	static String intToString(int time) {
		String si = "" + time / 60;
		String bun = "" + time % 60;
		if (si.length() == 1) {
			si = "0" + si;
		}
		if (bun.length() == 1) {
			bun = "0" + bun;
		}
		return si+":"+bun;
		
	}
	
	static int timeToInt(String time) {
		String[] parts = time.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}
}
