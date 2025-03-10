import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> list = new ArrayList<Integer>();
        int[] idxArr = new int[N+1];
        for (int i = 1; i <= N; i++) {
        	int cur = arr[i];
        	int pos = Collections.binarySearch(list, cur);
        	
        	if (pos < 0) {
        		pos = -pos - 1;
        	}
        	
        	if (pos == list.size()) {
        		list.add(cur);
        	} else {
        		list.set(pos, cur);
        	}
        	idxArr[i] = pos;
        }
        
        System.out.println(list.size());
        int size = list.size() - 1;
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = N; i >= 1; i--) {
        	if (idxArr[i] == size) {
        		stk.add(arr[i]);
        		size--;
        	}
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
        	sb.append(stk.pop()).append(" ");
        }
        System.out.println(sb);
    } // main
    
    
}