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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		Collections.sort(list);
		for (int i = 1; i <= M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			int c = Collections.binarySearch(list, cur);
			System.out.print(c >= 0 ? 1 : 0);
			System.out.print(" ");
		}
	} // main
}