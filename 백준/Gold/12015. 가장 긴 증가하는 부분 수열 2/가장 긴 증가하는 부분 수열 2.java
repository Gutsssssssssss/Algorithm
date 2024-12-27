import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			int pos = Collections.binarySearch(list, arr[i]);
			
			if (pos < 0) {
				pos = -(pos + 1);
			} else {
				continue;
			}
			if (list.size() == pos) {
				list.add(arr[i]);
			} else 
			list.set(pos, arr[i]);
		}
		System.out.println(list.size());
	}
}