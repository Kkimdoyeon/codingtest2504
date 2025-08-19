package algo.ct.M6;

import java.util.Arrays;

public class Q0819 {

    // 가장 작은 양수 값
    public static int[] arr = {-100000, 300, 0, 1, 2, 55, -66, 2756, -900};
    public static void main(String[] args) {
        int len = arr.length;
        int tmp;

        Arrays.sort(arr); // O(N log N)
//        // 오름차순 정렬
//        for (int i = 0; i < len-1; i++) {
//            for (int j = i+1; j < len-1; j++) {
//                if (arr[i] > arr[j]) {
//                    tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }

        int x;
        // 제일 작은 양수값 찾기
        for (x = 0; x < len; x++) {
            if (arr[x] >= 0)
                if (arr[x+1] == arr[x] + 1)
                    continue;
                else
                    break;
        }

        System.out.println(arr[x]+1);
    }
}
