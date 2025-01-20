import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<Integer>();
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			while (temp < arr[i]) {
				sb.append("+").append("\n");
				temp++;
				st.add(temp);
			}
			
			if (temp >= arr[i]) {
				int now = st.pop();
				if (arr[i] == now) {
					sb.append("-").append("\n");
				} else {
					flag = true;
				}
			}
		}
		if (flag) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	} // main
}