import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 입력 처리
        int N = sc.nextInt();
        int C = sc.nextInt();
        
        long[] houses = new long[N];
        for(int i = 0; i < N; i++) {
            houses[i] = sc.nextLong();
        }
        
        // 2. 집의 좌표 정렬
        Arrays.sort(houses);
        
        // 3. 이분 탐색 범위 설정
        long left = 1; // 최소 간격
        long right = houses[N - 1] - houses[0]; // 최대 간격
        long answer = 0;
        
        // 4. 이분 탐색
        while(left <= right) {
            long mid = (left + right) / 2; 
            
            // 배치 가능 여부 판단
            if(canPlaceRouters(houses, C, mid)) {
                answer = mid;     // 배치 가능하면 답 갱신
                left = mid + 1;   // 더 넓혀서 탐색
            } else {
                right = mid - 1;  // 불가능하면 범위 좁혀서 탐색
            }
        }
        
        // 5. 결과 출력
        System.out.println(answer);
    }
    
    // 주어진 간격(dist)으로 C개의 공유기를 놓을 수 있는지 검사하는 함수
    private static boolean canPlaceRouters(long[] houses, int C, long dist) {
        // 첫 번째 집에 공유기를 설치하고 시작
        long lastPosition = houses[0];
        int count = 1;  // 이미 첫 집에 공유기 1대 설치
        
        for(int i = 1; i < houses.length; i++) {
            if(houses[i] - lastPosition >= dist) {
                // dist 이상의 간격을 두고 공유기 설치 가능
                count++;
                lastPosition = houses[i];
                if(count == C) {
                    return true;
                }
            }
        }
        
        return false;
    }
}