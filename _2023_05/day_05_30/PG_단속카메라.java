package com.ssafy._2023_05.day_05_30;

import java.util.*;

public class PG_단속카메라 {


    // 1. 앞의 차량과 시작점이 같은 경우
    // 2. 아니라면, 앞의 차량과 끝 점이 겹치는 경우
    // 3.
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;

            Arrays.sort(routes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            int cam = Integer.MIN_VALUE;

            // 끝나는 지점을 기준으로 오름차순 정렬한다.
            // 정렬한 route 의 시작 지점이 cam 을 설치한 지점보다 크다면? (찍힘 ㅋ)
            // 그 이유는! 차량이 나가는 지점이 겹치면 그냥 카메라 하나로 퉁치면 되기 때문이다.
            // 따라서 카메라 위치보다 시작 지점이 큰(겹치지 않는 차량의 이동경로) 부분의
            // 끝나는 지점에 카메라를 설치한다.
            for (int[] route : routes) {
                if (cam < route[0]) {
                    cam = route[1];
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
    }
}
