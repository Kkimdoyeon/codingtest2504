package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리_S1 {
    static int N, M;
    static int arr[];
    static int amount = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int minV = -1;
        int maxV = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            minV = (Math.max(minV, arr[i]));
            maxV += arr[i];
        }

        int answer = 0;
        while (minV <= maxV) {
            int mid = (minV + maxV) / 2;

            if (find(mid)) {
                answer = mid;
                maxV = mid - 1;
            } else {
                minV = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean find(int amount) {
        int accountBal = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            if (accountBal < arr[i]) { // 남아있는 액수보다 인출해야되는 액수가 더 클 때
                accountBal += amount;
                result++;

                if (accountBal < arr[i]) // 충전했는데도 돈이 부족하다면? return
                    return false;
                accountBal -= arr[i];
            } else {
                accountBal -= arr[i];
            }

            if (result > M)
                return false; // 횟수가 넘어감
        }
        return true; // 충전하는 액수가 더 작아도 되거나, 정답일 수 있다는 말
    }
}
