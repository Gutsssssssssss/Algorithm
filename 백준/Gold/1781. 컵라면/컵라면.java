import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<int[]>();
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] cur : list) {
        	int d = cur[0];
        	int p = cur[1];
        	
        	if (pq.size() < d) {
        		pq.add(p);
        	} else if (pq.peek() < p) {
        		pq.poll();
        		pq.add(p);
        	}
        }
        int sum = 0;
        while (!pq.isEmpty()) {
        	sum += pq.poll();
        }
        System.out.println(sum);
    } // main
    
}