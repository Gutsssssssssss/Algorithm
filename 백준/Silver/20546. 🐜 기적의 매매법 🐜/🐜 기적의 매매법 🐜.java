import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int DAYS = 15;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());
		int[] price = new int[DAYS];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < DAYS; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int jhSum = jh(price, sum);
		int smSum = sm(price, sum);
		if (jhSum > smSum) System.out.println("BNP");
		else if (jhSum < smSum) System.out.println("TIMING");
		else System.out.println("SAMESAME");
	} // main
	
	private static int sm(int[] price, int sum) {
		
		int upCnt = 0;
		int downCnt = 0;
		int prev = -1;
		int total = 0;
		for (int i = 1; i < DAYS; i++) {
			if (i != 1) {
				if (prev > price[i]) {
					downCnt++;
					upCnt = 0;
				} else if (prev < price[i]) {
					upCnt++;
					downCnt = 0;
				} else {
					upCnt = 0;
					downCnt = 0;
				}
			}
			if (downCnt >= 3) {
				// 매수
				int cnt = sum / price[i];
				sum -= cnt * price[i];
				total += cnt;
			} else if (upCnt >= 3) {
				// 매도
				sum += total * price[i];
				total = 0;
			}
			prev = price[i];
		}
		return sum + (total * price[14]);
	}

	private static int jh(int[] price, int sum) {
		int total = 0;
		for (int i = 1; i < DAYS; i++) {
			int cnt = sum / price[i];
			
			sum -= (cnt * price[i]);
			total += cnt;
		}
		
		return sum + (total * price[14]);
	}
} // class