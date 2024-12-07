import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 실행
        rotateArray();

        // 회전 결과 출력
        printArray();
    }

    // 배열을 출력하는 메소드
    public static void printArray() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 배열을 반시계 방향으로 R번 회전하는 메소드
    public static void rotateArray() {
        int layers = Math.min(N, M) / 2;  // 배열의 층(layer) 개수

        for (int layer = 0; layer < layers; layer++) {
            // 현재 layer의 길이 계산
            int height = N - 2 * layer;
            int width = M - 2 * layer;
            int perimeter = 2 * (height + width - 2);  // 테두리 둘레 길이

            // R번 회전 후 이동할 칸 수 계산 (모듈러 연산)
            int rotateSteps = R % perimeter;

            // 테두리 원소를 리스트로 저장
            List<Integer> temp = extractLayer(layer);

            // 테두리 회전
            Collections.rotate(temp, -rotateSteps);

            // 회전한 테두리 배열에 다시 반영
            insertLayer(layer, temp);
        }
    }

    // 특정 층의 테두리 원소를 리스트로 추출하는 메소드
    public static List<Integer> extractLayer(int layer) {
        List<Integer> temp = new ArrayList<>();

        // 상단 테두리
        for (int i = layer; i < M - layer; i++) temp.add(arr[layer][i]);
        // 우측 테두리
        for (int i = layer + 1; i < N - layer; i++) temp.add(arr[i][M - layer - 1]);
        // 하단 테두리
        for (int i = M - layer - 2; i >= layer; i--) temp.add(arr[N - layer - 1][i]);
        // 좌측 테두리
        for (int i = N - layer - 2; i > layer; i--) temp.add(arr[i][layer]);

        return temp;
    }

    // 회전한 테두리 원소를 배열에 다시 삽입하는 메소드
    public static void insertLayer(int layer, List<Integer> temp) {
        int idx = 0;

        // 상단 테두리
        for (int i = layer; i < M - layer; i++) arr[layer][i] = temp.get(idx++);
        // 우측 테두리
        for (int i = layer + 1; i < N - layer; i++) arr[i][M - layer - 1] = temp.get(idx++);
        // 하단 테두리
        for (int i = M - layer - 2; i >= layer; i--) arr[N - layer - 1][i] = temp.get(idx++);
        // 좌측 테두리
        for (int i = N - layer - 2; i > layer; i--) arr[i][layer] = temp.get(idx++);
    }
}