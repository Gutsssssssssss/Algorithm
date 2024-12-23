import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oct = br.readLine();

        // 입력이 0일 때 바로 0 출력
        if (oct.equals("0")) {
            System.out.println("0");
            return;
        }

        // 각 8진수 숫자에 대응되는 2진수 문자열 배열
        String[] octToBin = {
            "000", "001", "010", "011", "100", "101", "110", "111"
        };

        StringBuilder sb = new StringBuilder();

        // 첫 번째 8진수 숫자 처리 (앞의 0 제거)
        int firstDigit = oct.charAt(0) - '0';
        sb.append(Integer.toBinaryString(firstDigit)); // 직접 처리 (1, 10, 11 등으로 시작)

        // 나머지 숫자들은 항상 3비트로 변환
        for (int i = 1; i < oct.length(); i++) {
            int digit = oct.charAt(i) - '0';
            sb.append(octToBin[digit]);
        }

        // 최종 출력
        System.out.println(sb.toString());
    }
}