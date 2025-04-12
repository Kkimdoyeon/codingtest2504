package main.java.algo.ct.M4_2;

import java.util.*;
import java.io.*;

public class BOJ_1024_S2 {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int len = L; len <= 100; len++) {
            // (N - len*(len-1)/2) 가 음수이면 성립할 수 없음
            int temp = N - len*(len-1) / 2;
            if (temp < 0) continue; // break 해도 됨, 근데 마지막에 return; 하기 때문에 이렇게 해도 괜찮음

            // 시작 수 a가 정수인지 확인
            if (temp % len != 0) continue;  // continue하면 for문 밖으로 나가게 됨

            int a = temp/len;

            // 시작 수가 음수면 안 됨 (자연수거나 0 포함해야 됨)
            if (a < 0) continue;

            for (int i = 0; i < len; i++)
                System.out.print((a+i) + " ");
            return;
        }

        System.out.println("-1");

    }
}
