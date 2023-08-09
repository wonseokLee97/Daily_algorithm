package com.ssafy._2023_08.day_08_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13144_ListOfUniqueNumbers {
    static int arr[], N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = 0;
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1;
        int e = 0;

        int[] cnt = new int[100001];

        while (s <= N) {
            // 종점이 마지막에 도달할 때 까지, 그리고 다음 연속된 수열의 선택이 중복이 아니라면
            while (e + 1 <= N && cnt[arr[e + 1]] == 0) {
                cnt[arr[++e]]++;
            }

            // 중복이 발견할 것 같거나, 종점에 도달했다면
            // 연속된 수열의 길이를 더해준다. (갯수)
            ans += e - s + 1;

            // 시작점을 한 칸 이동한다. (이동하기 전의 카운팅은 -1)
            cnt[arr[s++]]--;
        }

        // 핵심은, 종점에 도달하거나 중복된 수열이 등장하면 시작점 s를 한 칸 앞으로 전진해야한다.
        // 종점에 이미 도달한 경우는 계속해서 시작점을 전진하고,
        // 중복이 제거될 때 까지 시작점을 앞으로

        System.out.println(ans);
    }
}


// 1, 1 2, 1 2 3
// 2, 2 3, 2 3 1
// 3, 3 1, 3 1 2
// 1, 1 2
// 2

// 5
// 1 2 3 1 2
//       l
//         r

// 3 + 3 + 3 + 2 + 1

// 중복이 발견되면 중복이 없을때까지 l를 이동