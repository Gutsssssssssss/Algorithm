import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] freq = new int[100001];  // 숫자는 1 ~ 100000
        int lo = 0, hi = 0, maxLen = 0;

        while (hi < N) {
            if (freq[nums[hi]] < K) {
                freq[nums[hi]]++;
                hi++;
                maxLen = Math.max(maxLen, hi - lo);
            } else {
                freq[nums[lo]]--;
                lo++;
            }
        }

        System.out.println(maxLen);
    }
}
