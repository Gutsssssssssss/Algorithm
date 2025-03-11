

import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        System.out.println(go(B));
    } // main
    
    static long go(int num) {
    	if (num == 1) {
    		return A % C;
    	}
    	
    	long ret = go(num / 2);
    	ret = ret * ret % C;
    	if (num % 2 != 0) ret = ret * A % C;
    	
    	return ret;
    }
}
