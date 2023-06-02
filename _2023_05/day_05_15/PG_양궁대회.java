package com.ssafy._2023_05.day_05_15;

import java.util.Arrays;

class Solution {
    static int n, visited[], info[], max_val, max_visited[];

    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int total = 0;

        max_val = Integer.MIN_VALUE;
        this.n = n;
        this.info = info;
        visited = new int[11];
        max_visited = new int[11];

        dfs(0, 0);

        System.out.println(Arrays.toString(max_visited));

        for (int i : max_visited) {
            total += i;
        }

        if (total == 0) {
            return new int[]{-1};
        } else {
            return max_visited;
        }
    }

    public void dfs(int start, int sum) {
        System.out.println(Arrays.toString(visited) + ", " + sum);

        if (sum == n) {
            System.out.println("=====================");

            validate();
            return;
        }

        for (int i = start; i < info.length; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            // 무적권 이겨야하기 때문에, 어피치의 화살개수 + 1개 만큼 화살을 소비한다.
            dfs(i + 1, sum + 1);
            visited[i] = 0;
        }
    }

    // 0-10, 1-9, 2-8, 3-7, 4-6 ... 10-0

    private void validate() {
        int lion = 0;
        int apeach = 0;

        for (int i = 0; i < 11; i++) {
            // 라이언이 이긴 경우?
            if (visited[i] == 1) {
                lion += (10 - i);
            } else { // 라이언이 진 경우
                if (info[i] >= 1) {
                    apeach += (10 - i);
                }
            }
        }

        System.out.println(lion + ", " + apeach + ", " + (lion - apeach) + ", " + max_val);

        // 라이언이 이긴 경우에
        if (lion > apeach) {

            if (lion - apeach == max_val) {
                System.out.println("HELLO!");
            }

            // 최대 점수만 기록하자.
            if (lion - apeach > max_val) {
                max_val = lion - apeach;

                max_visited = new int[11];
                for (int i = 0; i < 11; i++) {
                    if (visited[i] == 1) {
                        max_visited[i] = info[i] + 1;
                    }
                }
//                System.out.println("1");

//                System.out.println(Arrays.toString(visited));
//                System.out.println(max_val);
//                System.out.println(Arrays.toString(max_visited));

            } else if (lion - apeach == max_val) { // 최대 점수가 동점인 경우
                int[] validate_visited = new int[11];

                for (int i = 0; i < 11; i++) {
                    if (visited[i] == 1) {
                        // 새로운 과녁점수 도전자
                        validate_visited[i] = info[i] + 1;
                    }
                }

                // 가장 낮은 과녁점수부터 시작해서 많이 맞춘 배열을 가져간다.
                for (int i = 10; i >= 0; i--) {
                    if (validate_visited[i] > max_visited[i]) {
                        for (int j = 0; j < 11; j++) {
                            max_visited[j] = validate_visited[j];
                        }

//                        System.out.println(Arrays.toString(visited));
//                        System.out.println(max_val);
//                        System.out.println(Arrays.toString(max_visited));

                        return;
                    }
                }
            }
        }
    }
}

// 10 9 8 7 6 5 4 3 0 0 0
//

public class PG_양궁대회 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(10, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
    }


}

// 10, 9, 8, 7 => 34
// 한 마디로, 라이언이 높은 점수를 받기 위해서는 어피치의 점수를 상쇄시키고 자신이 높은 점수를 받아야 한다.
// 반드시 이겨야지만 점수를 받는다.
// 조합을 이용한다. 이기는 경우와 지는 경우
// l, w, w, l, w, l, l ...
// w, w, l, l, l, l, l ...
// w, l, w, l, l, l, l ...

// lion[j]++;