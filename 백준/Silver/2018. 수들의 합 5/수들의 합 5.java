import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int lo = 1; int hi = 1;
        int sum = 1;
        int cnt = 1;
        while (hi < N) {
        	if (sum <= N) {
        		hi++;
        		sum += hi;
        	} else if (sum > N) {
        		sum -= lo;
        		lo++;
        	} 
        	if(sum == N) {
        		cnt++;
        	}
        }
        System.out.println(cnt);
    } // main
}