package algo.ct.M10;
// 2:06~2:54

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2331_반복수열_S4 {
    static int A, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A);

        while (true) {
            int nextNum = next(arr.get(arr.size() - 1));
            if (arr.contains(nextNum)) {
                int idx = arr.indexOf(nextNum);
                System.out.println(idx);
                break;
            }
            arr.add(nextNum);
        }
    }

    static int next(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, P);
            num /= 10;
        }
        return sum;
    }
}
