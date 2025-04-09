import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        int[][] map = new int[101][101];
        // 그리기
        for (int i = 0; i < rectangle.length; i++) {
            int[] r = rectangle[i];
            draw(r, map);
        }
        
        // for (int i = 0; i < 20; i++) {
        //     for (int j = 0; j < 20; j++) {
        //         System.out.print(map[i][j] + " ");
        //     } System.out.println();
        // }
        
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[101][101];
        q.add(new int[] {characterX, characterY});
        visited[characterX][characterY] = 1;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            if (cx == itemX && cy == itemY){
                     break;
                }
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (ny < 0 || ny >= 101 || nx < 0 || nx >= 101 || map[nx][ny] == 0 || map[nx][ny] == 2 || visited[nx][ny] != 0) continue;
                visited[nx][ny] = visited[cx][cy] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        
        int answer = visited[itemX][itemY] / 2;
        return answer;
    }
    
    void draw(int[] r, int[][] map) {
        int sx = r[0];
        int sy = r[1];
        int ex = r[2];
        int ey = r[3];
        
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (map[i][j] != 2 && (i == sx || i == ex || j == sy || j == ey)) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                }
            }
        }
    }
}