
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[N];
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		int p1 = 0;
		int p2 = 0;
		List<Integer> ans = new ArrayList<>();
		while (p1 < N || p2 < M) {
			if ((p1 < N && p2 < M) && arr1[p1] > arr2[p2]) {
				ans.add(arr2[p2]);
				p2++;
			} else if ((p1 < N && p2 < M) && arr1[p1] < arr2[p2]) {
				ans.add(arr1[p1]);
				p1++;
			} else if ((p1 < N && p2 < M) && arr1[p1] == arr2[p2]) {
				ans.add(arr1[p1]);
				ans.add(arr2[p2]);
				p1++;
				p2++;
			} else if (p1 == N && p2 < M) {
				ans.add(arr2[p2]);
				p2++;
			} else if (p2 == M && p1 < N) {
				ans.add(arr1[p1]);
				p1++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	} // main
}
