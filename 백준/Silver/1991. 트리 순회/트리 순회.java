import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static Node[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new Node[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new Node(i);
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			int cur = a.charAt(0)-'A' + 1;
			Node l = b.charAt(0) == '.' ? null : arr[b.charAt(0) - 'A' + 1];
			Node r = c.charAt(0) == '.' ? null : arr[c.charAt(0) - 'A' + 1];
			arr[cur].left = l;
			arr[cur].right = r;
		}
		go(1);
		sb.append("\n");
		go2(1);
		sb.append("\n");
		go3(1);
		System.out.println(sb);
	} // main
	
	static void go3(int idx) {
		Node here = arr[idx];
		
		if (here.left != null) {
			go3(here.left.num);
		}
		if (here.right != null) {
			go3(here.right.num);
		}
		sb.append((char) (here.num - 1 + 'A'));
	}
	
	static void go2(int idx) {
		Node here = arr[idx];
		
		if (here.left != null) {
			go2(here.left.num);
		}
		sb.append((char) (here.num - 1 + 'A'));
		if (here.right != null) {
			go2(here.right.num);
		}
	}
	
	static void go(int idx) {
		Node here = arr[idx];
		sb.append((char) (here.num - 1 + 'A'));
		if (here.left != null) {
			go(here.left.num);
		}
		if (here.right != null) {
			go(here.right.num);
		}
	}
	
	static class Node {
		Node left;
		Node right;
		int num;
		Node(int num) {
			this.num = num;
		}
	}
}