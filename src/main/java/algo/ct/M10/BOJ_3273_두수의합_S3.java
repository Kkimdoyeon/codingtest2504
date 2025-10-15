package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합_S3 {
    static int n;
    static int[] arr;
    static int sum;
    static int check = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int x = arr[left] + arr[right];
            if (x == sum) {
                check++;
                left++;
                right--;
            } else if (x < sum) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(check);
    }
}
