package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_하노이탑이동순서_G5 {

    static void hanoi(int n, int from, int to) {
        int mid = 6 - from - to;

        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        if (n >= 2) {
            hanoi(n - 1, from, mid);
            System.out.println(from + " " + to);
            hanoi(n - 1, mid, to);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, N)-1);
        hanoi(N, 1, 3);
    }
}
