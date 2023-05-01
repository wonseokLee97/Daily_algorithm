package com.ssafy._2023_03.day_05_01;

import java.util.Arrays;

public class PG_타겟넘버 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        int[] numbers = new int[]{4, 1, 2, 1};
        int target = 4;

        System.out.println(s.solution(numbers, target));
    }

}

// 1. visited 배열을 활용한다.
// 2. 해당 배열을 방문처리하면, 음수로 변환한다.
// 3. 총 합이 target 미만일 경우, return.
// 3-1. 총 합이 target 과 동일할 경우 cnt++;


class Solution1 {
    static int answer, target, visited[], numbers[];
    public int solution(int[] numbers, int target) {
        answer = 0;

        this.target = target;
        this.numbers = numbers;
        visited = new int[numbers.length];

        dfs(0, 0);

        return answer;
    }

    public static void dfs(int start, int cnt) {

//        System.out.println(Arrays.toString(visited));
        if (isRight()) {
//            System.out.println("answer!!");
            answer++;
            return;
        }


        for (int i = start; i < numbers.length; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            dfs(i + 1, cnt + 1);
            visited[i] = 0;
        }
    }

    private static boolean isRight() {
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i] == 1) {
                result += numbers[i] * (-1);
            } else {
                result += numbers[i];
            }
        }

        if (result == target) {
            return true;
        } else {
            return false;
        }
    }
}