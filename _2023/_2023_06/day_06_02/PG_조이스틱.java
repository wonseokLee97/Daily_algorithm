package com.ssafy._2023._2023_06.day_06_02;

public class PG_조이스틱 {

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int move = name.length() - 1;
            int idx = 0;

            char[] arr = name.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - 'A' >= 13) {
                    answer += 26 - (arr[i] - 'A');
                } else if (arr[i] - 'A' < 13) {
                    answer += arr[i] - 'A';
                }


                // 현재 위치 다음부터
                idx = i + 1;

                // 연속된 A의 길이 + A 이전까지의 길이
                while (idx < arr.length && arr[idx] == 'A') {
                    idx++;
                }

                // 1직선 무빙 vs 현재 위치(i) 까지 갔다 돌아서 가는 경우
                move = Math.min(move, i * 2 + (arr.length - idx));
                move = Math.min(move, i + 2 * (arr.length - idx));
            }

            return answer + move;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("JEROEN");
    }
}
