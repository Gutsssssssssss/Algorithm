import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_009;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 입력받은 (N, M) 저장 + 최대값 파악
        int[] Ns = new int[T];
        int[] Ms = new int[T];
        int maxN = 0;
        int maxM = 0;
        
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ns[i] = Integer.parseInt(st.nextToken());
            Ms[i] = Integer.parseInt(st.nextToken());
            maxN = Math.max(maxN, Ns[i]);
            maxM = Math.max(maxM, Ms[i]);
        }
        
        // dp[i][j] : 정수 i를 1,2,3의 합으로 나타내되, 정확히 j개의 수를 사용한 경우의 수
        long[][] dp = new long[maxN + 1][maxM + 1];
        
        // 초기값 설정
        dp[0][0] = 1; // 0을 0개의 수로 만드는 방법은 1가지
        
        // DP 구성
        for(int i = 1; i <= maxN; i++) {
            for(int j = 1; j <= i && j <= maxM; j++) {
                long sum = 0;
                if(i - 1 >= 0) sum = (sum + dp[i - 1][j - 1]) % MOD;
                if(i - 2 >= 0) sum = (sum + dp[i - 2][j - 1]) % MOD;
                if(i - 3 >= 0) sum = (sum + dp[i - 3][j - 1]) % MOD;
                
                dp[i][j] = sum;
            }
        }
        
        // 각 테스트 케이스별 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int n = Ns[i];
            int m = Ms[i];
            sb.append(dp[n][m]).append("\n");
        }
        
        System.out.println(sb);
    }
}