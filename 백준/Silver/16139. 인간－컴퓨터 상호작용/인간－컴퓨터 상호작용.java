import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] s = br.readLine().toCharArray();
		int size = s.length;
		
		int[][] arr = new int[size + 1][26];
		
		for (int i = 1; i <= size; i++) {
			char c = s[i-1];
			arr[i][c-'a'] = 1;
			for (int j = 0; j < 26; j++) {
				arr[i][j] += arr[i-1][j];
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken()) + 1;
			sb.append(arr[r][c-'a'] - arr[l][c-'a']).append("\n");
		}
		System.out.println(sb);
	} // main
} // class