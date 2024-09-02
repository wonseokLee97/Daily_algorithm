package com.ssafy._2023._2023_07.day_07_02;

import java.util.*;

class Info implements Comparable<Info> {
    int emoP;
    int totalP;

    public Info (int emoP, int totalP) {
        this.emoP = emoP;
        this.totalP = totalP;
    }

    @Override
    public int compareTo(Info info) {
        if (info.emoP == emoP) {
            return Integer.compare(info.totalP, totalP);
        } else {
            return Integer.compare(info.emoP, emoP);
        }
    }
}

class Emoticon {
    static int[] discount = {40, 30, 20, 10};
    static int N, arr[], users[][];
    static List<Info> list;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        list = new ArrayList<>();
        N = emoticons.length;
        arr = new int[N];

        dfs(0, users, emoticons);

        Collections.sort(list);

        Info info = list.get(0);
        // System.out.println(info.emoP + ", " + info.totalP);

        answer = new int[2];
        answer[0] = info.emoP;
        answer[1] = info.totalP;

        return answer;
    }

    public void dfs(int cnt, int[][] users, int[] emoticons) {
        if (cnt == N) {
            check(arr, users, emoticons);
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[cnt] = discount[i];
            dfs(cnt + 1, users, emoticons);
        }
    }

    public void check(int[] arr, int[][] users, int[] emoticons) {
        int emoPlus = 0;
        int totalPay = 0;

        // System.out.println(Arrays.toString(arr));

        // 각각의 유저별로
        for (int[] user : users) {
            int lower_dis = user[0];
            int max_cost = user[1];
            int total = 0;


            // 할인율을 적용한다.
            for (int i = 0; i < arr.length; i++) {
                // 유저의 최소 할인율 이상인 물건만 산다.
                if (arr[i] < lower_dis) {
                    continue;
                }

                total += emoticons[i] * (100 - arr[i]) / 100;
            }

            // 최대 구매비용보다 크다면
            if (total >= max_cost) {
                emoPlus++;
            } else {
                totalPay += total;
            }
        }


        list.add(new Info(emoPlus, totalPay));
    }
}


// 비율이 x% 이상 인 경우 모두 구매
// 가격 y를 넘어가게 되면 구매를 취소하고 플러스 서비스에 가입.

// [x, y]
// 이모티콘 플러스 가입자를 최대로.. x를 기준으로 정렬, 후에 y로 정렬.

// 7개의 이모티콘에 각각 4개의 비율을 모두 적용해보는 부르트포스? - ㄴ

// 이모티콘 플러스 가입자를 최대로 늘리는 방법
// 최소한의 할인률로 가격 기준을 넘겨야한다.
// 그렇다면..

// 40, 30, 20, 10
// 7000, 9000 두 개 2p4 / 중복순열
