package com.ssafy._2023_05.day_05_07;

import java.util.*;

class PG_연속된_부분_수열의_합 {

    public static void main(String[] args) {
        Solution s = new Solution();

        s.solution(new int[]{2, 2, 2, 2, 2}, 6);
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
        int e = 0;
        int result = 0;
        int len = Integer.MAX_VALUE;

        answer = new int[]{0, 0};

        while (s < e && e <= sequence.length) {
            if (s == e) {
                result = sequence[s];
            }

            // 누적합이 k인 경우
            if (result == k) {
                // 이전 정답의 길이보다 현재 인덱스간의 길이가 짧을경우,
                if (len > e - s + 1) {
                    len = e - s + 1;
                    answer[0] = s;
                    answer[1] = e;
                }
            }

            // 정답이 된 시작 인덱스를 빼주고
            result -= sequence[s];

            if (e + 1 < )


        }

        return answer;
    }
}
