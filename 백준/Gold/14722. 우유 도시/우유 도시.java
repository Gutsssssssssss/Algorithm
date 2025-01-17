import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n * n];

        // Read the 2D array and flatten it into a 1D array
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i * n + j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = n + 1;
        int[] d = new int[m * m];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int t = i * m + j;
                d[t] = Math.max(d[t - m], d[t - 1]);
                if (d[t] % 3 == a[t - n - i - 1]) {
                    d[t]++;
                }
            }
        }

        System.out.println(d[m * m - 1]);
    }
}