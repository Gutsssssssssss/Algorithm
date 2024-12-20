import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int[] modCount = new int[M];
        long prefixSum = 0;
        
        for (int i = 0; i < N; i++) {
            prefixSum += arr[i];
            int remainder = (int)(prefixSum % M);
            if (remainder == 0) {
                count++; 
            }
            modCount[remainder]++; 
        }

        // modCount[r] 중에서 2개를 택해 (i < j) 형태로 가능한 조합을 모두 더한다.
        for (int i = 0; i < M; i++) {
            if (modCount[i] > 1) {
                // nC2 = n*(n-1)/2
                count += (long)modCount[i] * (modCount[i] - 1) / 2;
            }
        }

        System.out.println(count);
    }
}