package com.ssafy._2023._2023_06.day_06_20;

import java.util.*;
import java.io.*;

public class BJ_21921_블로그 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        // 블로그가 시작 후 지난 N일
        int N = Integer.parseInt(st.nextToken());
        // X일 동안 가장 많이 들어온 방문자 수
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        for (int i = 0; i < X; i++) {
            total += arr[i];
        }

        int idx = 0;
        int max_val = total;

        map.put(total, 1);

        // 슬라이딩 윈도우
        // X의 크기만큼 idx 차이를 두고, 마지막 까지 순차적으로 탐색하며 최대 방문자수를 구한다.
        while ((idx + X) < N) {
            // System.out.println("total: " + total);
            // System.out.println(idx + ", " + (idx + X) + ", " + N);

            total -= arr[idx];
            total += arr[idx++ + X];

            // System.out.println(total);

            max_val = Math.max(max_val, total);

            if (map.get(total) == null) {
                // System.out.println(max_val + "!!");
                map.put(total, 1);
            } else {
                // System.out.println(max_val + "??");
                map.put(total, map.get(total) + 1);
            }
        }

        if (max_val == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max_val + "\n" + map.get(max_val));
        }
    }
}
