package main.java.algo.ct.M4_2;

import java.io.*;
public class BOJ_10872_B3 {
    static int N; // 0<=N<=12
    static int sum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++)
            sum *= i;
        System.out.println(sum);
    }
}
