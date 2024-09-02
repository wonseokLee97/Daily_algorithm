package com.ssafy._2023._2023_08.day_08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BJ_19699_소난다 {
    static int N, M, visited[], arr[];
    static List<Integer> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N];
        arr = new int[N];
        ans = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a + " ");
        }

        if (ans.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void comb(int cnt, int start) {
        if (cnt == M) {
            int val = 0;
            int flag = 0;

            for (int i = 0; i < N; i++) {
                if (visited[i] == 1) {
                    val += arr[i];
                }
            }

            // 2 부터 자기 자신을 제외한 값으로 나누었을 때 나머지가 0이 아니면 소수
            for (int i = 2; i < val; i++) {
                if (val == 2) {
                    break;
                }

                // 소수가 아님!
                if (val % i == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag != 1) {
                if (!ans.contains(val)) {
                    ans.add(val);
                }
            }
        }

        for (int i = start; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(cnt + 1, i + 1);
            visited[i] = 0;
        }
    }
}

// 5마리중 3마리씩 뽑을건데, 걔네들 몸무게의 합이 소수인 경우 정답에 담아 오름차순으로 정렬
// 순서가 없기떄문에 조합