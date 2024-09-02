package com.ssafy._2024_08.BJ_2629_양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    static boolean dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new boolean[N + 1][40001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);

        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            int w = Integer.parseInt(st.nextToken());

            // 구슬의 무게를 만족하는 반대편 추의 무게의 합이 있다면
            if (dp[N][w]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    static void bt(int cnt, int sum) {
        // 추의 무게 합이 이미 기록되었다면
        if (dp[cnt][sum]) {
            return;
        }
        dp[cnt][sum] = true;

        if (cnt == N) {
            return;
        }

        // 추를 올리지 않는 경우
        bt(cnt + 1, sum);
        // 다음 추를 올리는 경우
        bt(cnt + 1, sum + arr[cnt]);
        // 추를 반대쪽으로 옮기는 경우
        bt(cnt + 1, Math.abs(sum - arr[cnt]));
    }
}

//2   : 추의 개수
//1 4 : 추의 무게들 (가벼운 순)
//2   : 구슬의 개수
//3 2 : 구슬의 무게들

// 추의무게\
//      1
//      2
//      3
//      4


// 3 : (1+3) vs (4)
// 2 :

//따라서 추의 무게 조합 방법은 총 3가지임을 알 수 있다.
//
//추 하나 그대로 무게
//현재 추의 무게에 새로운 추 더하기 (구슬  <-> 추+새로운 추)
//현재 추의 무게에 반대편에 새로운 추 더해서 총 무게 빼기 (구슬+새로운 추 <-> 추)
//
//
//이를 재귀호출탐색 방식으로 코딩하면 다음과 같다.
//
//static void dp(int cnt, int num) {
//    if(result[cnt][num]) return;
//    result[cnt][num] = true;
//
//    if(cnt == n) return;
//
//    1. 현재 추의 무게에 새로운 추 더하기 (구슬  <-> 추+새로운 추)
//    dp(cnt + 1, num+ w[cnt]);
//
//    2. 추 하나 그대로 무게
//    dp(cnt + 1, num);
//
//    3. 현재 추의 무게에 반대편에 새로운 추 더해서 총 무게 빼기 (구슬+새로운 추 <-> 추)
//    dp(cnt + 1, Math.abs(num- w[cnt]));
//}

// 예를들어, 무게가 4인 추가 있다면
// result[2][4] = true
// 1, 4 추 두개로는 3을 만들 수 없다.
// 1,4를 올린 상태에서 1을 반대쪽으로 빼면 무게가 3인 구슬을 올려도 평행이 맞는다.
// 반대쪽에 무게가 1인 추가 올라오는 경우, 4에서 1을 빼야한다.
// result[2][3] = true
//