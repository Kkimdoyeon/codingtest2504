package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1417_국회의원선거_S5 {
    static int n, m;
    static int result = 0;
    static int dasom;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());

        if (n > 1) {
            arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++)
                arr[i] = Integer.parseInt(br.readLine());

            while (true) {
                if (dasom <= arr[n - 2]) {
                    arr[n - 2]--;
                    dasom++;
                    result++;
                } else if (dasom > arr[n - 2])
                    break;
            }
        }

        System.out.println(result);
    }
}

