import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

	static int N, K, Q, M;
	static boolean[] dead;
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dead = new boolean[N+3];
		check = new int[N+3];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			dead[Integer.parseInt(st.nextToken())] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (dead[a]) continue;
			for (int j = a; j <= N + 2; j += a) {
				if (dead[j]) continue;
				check[j] = 1;
			}
		}
		
		int[] psum = new int[N+3];
		for (int i = 3; i <= N + 2; i++) {
			psum[i] = psum[i-1] + (check[i] == 0 ? 1 : 0);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			System.out.println(psum[E] - psum[S-1]);
		}
	
		
		
	} // main
} // class