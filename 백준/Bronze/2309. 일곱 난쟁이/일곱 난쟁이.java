import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		int first = -1;
		int second = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < i; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					first = arr[i]; second = arr[j];
				}
			}
		}
		Arrays.sort(arr);
		for (int i = 0; i < 9; i++) {
			if (arr[i] == first || arr[i] == second) continue;
			System.out.println(arr[i]);
		}
	} // main
}