package algo.ct.M01;

class PGS_43165_타겟넘버_Lv2 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length)  {
            if (sum == target)
                answer++;
            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}

//// 모든 경우의 수를 탐색하여 타겟 넘버에 도달할 수 있는지를 체크
//// 그럼 numbers는 그대로 두고 - + 조합만 다 구하면 됨
//
//class Solution {
//    static int[] result;
//    static int answer = 0;
//
//    public int solution(int[] numbers, int target) {
//        int size = numbers.length;
//        result = new int[size]; // 부호 조합
//
//        cal(0, size, numbers, target);
//
//        return answer;
//    }
//
//    public void cal(int depth, int size, int[] numbers, int target) {
//        if (depth == size) {
//            int sum = 0;
//            for (int i = 0; i < size; i++) {
//                sum += numbers[i] * result[i];
//            }
//            if (sum == target) answer++;
//            return;
//        }
//
//        // + 선택
//        result[depth] = 1;
//        cal(depth + 1, size, numbers, target);
//
//        // - 선택
//        result[depth] = -1;
//        cal(depth + 1, size, numbers, target);
//    }
//}