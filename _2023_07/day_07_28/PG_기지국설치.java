package com.ssafy._2023_07.day_07_28;

public class PG_기지국설치 {
    class Solution {
        public int gijiguk(int n, int[] stations, int w) {
            int answer = 0;
            int start = 1;

            // 기지국 기준 왼쪽의 경우를 구함
            for (int st : stations) {
                // 기지국의 왼쪽을 채워야하는 경우
                if (start < st - w) {
                    int end = st - w;

                    // 기지국의 개수
                    answer += (end - start) / (w * 2 + 1);

                    if ((end - start) % (w * 2 + 1) != 0) {
                        answer++;
                    }
                }

                // 시작지점을 현재 기지국 기준 오른쪽 끝으로 잡는다
                start = st + w + 1;
            }

            // 마지막 기지국에 오른쪽에 여분이 남는 경우
            if (stations[stations.length - 1] + w + 1 <= n) {
                // 마지막 기지국 범위가 끝나는 오른쪽 시작지점
                start = stations[stations.length - 1] + w + 1;
                int end = n + 1;

                // 기지국의 개수
                answer += (end - start) / (w * 2 + 1);

                if ((end - start) % (w * 2 + 1) != 0) {
                    answer++;
                }
            }


            return answer;
        }
    }

// 주어진 기지국의 위치 4, 11
// 범위는 3~5, 10~12
// 1부터 2까지 기지국이 몇개 필요한가? 기지국의 범위는 w*2+1 => 3
// 2 / 3 = 0. 나눈 값이 0이면 1개, 1 이상이면 그 수만큼 기지국이 필요. + 나머지값
}
