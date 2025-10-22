package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213_팰린드롬_S3 {
    static int[] count = new int[26]; // A~Z 각 문자 개수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            count[c - 'A']++;
        }

        int check = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                check++;
                if (check > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    break;
                }
            }
        }

        if (check <= 1) {
            StringBuilder left = new StringBuilder();

            // 왼쪽 절반 만들기
            for (int i = 0; i < 26; i++) {
                int half = count[i] / 2;
                for (int j = 0; j < half; j++) {
                    left.append((char)(i + 'A'));
                }
            }

            // 중앙 문자 결정 (홀수 개수 문자)
            String mid = "";
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 == 1) {
                    mid = String.valueOf((char)(i + 'A'));
                    break;
                }
            }

            // 오른쪽 절반 만들기
            StringBuilder leftToUse = new StringBuilder(left);
            String right = leftToUse.reverse().toString();

            System.out.println(left.toString() + mid + right);
        }
    }
}
