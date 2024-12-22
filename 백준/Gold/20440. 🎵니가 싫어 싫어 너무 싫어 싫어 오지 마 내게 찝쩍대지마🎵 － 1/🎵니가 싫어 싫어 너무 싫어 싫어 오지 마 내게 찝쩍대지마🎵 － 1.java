import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {
					Integer.parseInt(st.nextToken()),
					1
			});
			
			list.add(new int[] {
					Integer.parseInt(st.nextToken()),
					-1
			});
		}
		
		list.sort((a, b) -> (a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0])));
		
		
		int curSum = 0;
		int maxSum = 0;
		int start = 0, end = 0;
		boolean flag = false;
		int prev = 0;
		
		for (int[] cur : list) {
			int time = cur[0];
			int val = cur[1];
			
			curSum += val;
			
			if (curSum == maxSum && prev == time) {
				flag = true;
			} else if (curSum > maxSum) {
				maxSum = curSum;
				start = time;
				flag = true;
			} else if (curSum < maxSum && flag) {
				end = time;
				flag = false;
			}
			prev = time;
		}
		System.out.println(maxSum);
		System.out.println(start + " " + end);
	} // main
} // class