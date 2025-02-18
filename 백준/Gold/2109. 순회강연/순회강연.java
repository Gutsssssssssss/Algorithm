import java.io.*;
import java.util.*;

public class Main {

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	list.add(new int[] {
        			Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken())
        	});
        }
        
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] cur : list) {
        	int cd = cur[1];
        	int cp = cur[0];
        	if (pq.size() < cd) {
        		pq.add(cp);
        	} else if (!pq.isEmpty() && pq.peek() < cp){
        		pq.poll();
        		pq.add(cp);
        	}
        }
        
        int sum = 0;
        while (!pq.isEmpty()) {
        	sum += pq.poll();
        }
        System.out.println(sum);
    } // main
    
}