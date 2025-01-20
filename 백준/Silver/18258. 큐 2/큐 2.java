import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int CAPACITY = 2_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[CAPACITY];
		int front = 0;
		int back = -1;
		int size = 0; 
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			if (s.startsWith("push")) {
				String[] sarr = s.split(" ");
				int X = Integer.parseInt(sarr[1]);
				back = (back + 1) % CAPACITY;
				arr[back] = X;
				size++;
			} else if (s.equals("pop")) {
				if (size == 0) {
					sb.append(-1).append("\n");
				} else {
					int cur = arr[front];
					front = (front + 1) % CAPACITY;
					size--;
					sb.append(cur).append("\n");
				}
				
			} else if (s.equals("size")) {
				sb.append(size).append("\n");
			} else if (s.equals("empty")) {
				sb.append(size == 0 ? 1 : 0).append("\n");
			} else if (s.equals("front")) {
				if (size == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(arr[front]).append("\n");
				}
			} else if (s.equals("back")) {
				if (size == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(arr[back]).append("\n");
				}
			}
		}
		System.out.println(sb);
	} // main
}