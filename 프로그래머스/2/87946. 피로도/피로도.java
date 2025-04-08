import java.util.*;

class Solution {
    int N;
    int[][] dungeons;
    int ret;
    int k;
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        N = dungeons.length;
        boolean[] visited = new boolean[N+1];
        List<Integer> list = new ArrayList<>();
        go(visited, 0, list);
        int answer = ret;
        return answer;
    }
    int solve(List<Integer> list) {
        int temp = k;
        int ret = 0;
        for (int i : list) {
            int needP = dungeons[i][0];
            int minuP = dungeons[i][1];
            if (temp >= needP) {
                temp -= minuP;
                ret++;
            } else break;
        }
        return ret;
    }
    
    void go(boolean[] visited, int depth, List<Integer> list) {
        if (depth == N) {
            ret = Math.max(ret, solve(list));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(i);
            go(visited, depth + 1, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}