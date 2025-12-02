package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기_S1 {
    static int N;
    static int[] arr;
    static int[] operator = new int[4]; // +, -, x, ÷
    static int maxAnswer = Integer.MIN_VALUE;
    static int minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        // 숫자조합
        // 연산자조합
        //index: arr에서 현재 몇 번째 숫자를 사용할지
        //currentValue: 앞까지 계산된 결과
        dfs(1, arr[0]);
        // 그 조합끼리 계산

        System.out.println(maxAnswer);
        System.out.println(minAnswer);

    }

    public static void dfs(int depth, int currentValue) {
        if (depth == N) {
            maxAnswer = Math.max(currentValue, maxAnswer);
            minAnswer = Math.min(currentValue, minAnswer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                int next = calculate(currentValue, arr[depth], i);

                dfs(depth + 1, next);
                operator[i]++; // 백트래킹
            }
        }

    }

    public static int calculate(int sum, int num, int op) {
        if (op == 0)
            sum += num;
        if (op == 1)
            sum -= num;
        if (op == 2)
            sum *= num;
        if (op == 3) {
            if (sum < 0) return - ( Math.abs(sum) / num );
            else return sum / num;
        }

        return sum;
    }
}
