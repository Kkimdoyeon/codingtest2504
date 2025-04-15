package main.java.algo.ct.M4_2;

import java.io.*;
import java.util.*;

public class BOJ_14467_B1 {
    static int[] arr = new int[11];
    static int N, a, b;
    static int count = 0;

    public static void main(String[] args) throws IOException    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 11; i++) // i < N해서 런타임에러남;;
            arr[i] = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (arr[a] == (b-1) && b == 1) {
                count++;
                //System.out.println(arr[a]);
            }
            if (arr[a] == (b+1) && b == 0) {
                count++;
                //System.out.println(arr[a]);
            }

            arr[a] = b;
        }

        System.out.println(count);
    }
}