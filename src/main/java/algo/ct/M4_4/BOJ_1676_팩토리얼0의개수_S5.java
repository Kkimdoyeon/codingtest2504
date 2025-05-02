package main.java.algo.ct.M4_4;

import java.io.*;

public class BOJ_1676_팩토리얼0의개수_S5 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int check = 0;
        for (int i = 5; i <= N; i *= 5)
            check += N / i;

        System.out.println(check);
    }
}
