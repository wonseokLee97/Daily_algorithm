package com.ssafy._2023_05.day_05_07;

import java.util.*;

class PG_연속된_부분_수열의_합 {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(
                Arrays.toString(s.solution(new int[]{3, 4, 5, 6, 7}, 5))
        );
    }

}

// 1. 이분탐색 혹은 슬라이딩 윈도우 문제?일듯
// 2. s, e index를 지정하고, 그 사이의 원소값들의 합을 구한다.
// 3. 만약 k 값과 일치할 경우, 해당 배열의 길이에 따라 저장한다.
// 4. 모든 탐색을 마쳤을 경우, 가장 길이가 짧은 배열의 시작과 끝 인덱스를 구한다.

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int s = 0;
        int e = -1;
        int result = 0;

        answer = new int[]{-1, -1};

        // 1. s, e는 모두 0 부터 시작한다.
        // 2. s부터 e까지의 합이 k 보다 작은 경우, e를 증가시킨다.
        // 3. s부터 e까지의 합이 k 보다 큰 경우, s를 증가시키고 이전 s를 빼준다.
        // 4. s부터 e까지의 합이 k 인 경우, 정답을 저장한다.
        // 4-1. s부터 e까지의 길이가 이전 정답과 동일할 경우, 갱신 x
        // 4-2. s부터 e까지의 길이가 이전 정답보다 작을경우, 갱신 o

        while (true) {
            // 2. s부터 e까지의 합이 k 보다 작은 경우, e를 증가시킨다.
            if (result < k) {
                if ((e + 1) < sequence.length) {
                    result += sequence[++e];
                } else {
                    break;
                }
            }
            // 3. s부터 e까지의 합이 k 보다 큰 경우, s를 증가시키고 이전 s를 빼준다.
            else {
                result -= sequence[s++];
            }

            if (result == k) {
                if (e - s < answer[1] - answer[0]
                        || answer[1] == -1) {
                    answer[0] = s;
                    answer[1] = e;
                }
            }

            System.out.println(s + ", " + e + ", " + result);
        }

        return answer;
    }
}


//0, 1, 1
//0, 2, 2
//0, 3, 3
//0, 4, 5
//1, 4, 4
//1, 5, 7
//2, 5, 6
//3, 5, 5
//4, 5, 3
//4, 6, 7
//5, 6, 4
//5, 7, 9
//6, 7, 5
//7, 7, 0