package com.ssafy._2022_1.day_220808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1158_요세푸스문제_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st;

        // 입력값.
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 1;

        // 선형구조의 리스트를 구현해야 하기 때문에 LinkedList를 사용한다.
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        // 출력 조건을 맞추기 위해 q의 사이즈가 1이 될때까지
        while (q.size() != 1) {
            // cnt 가 K와 같아진다면 popleft 하여 출력한다.
            if (cnt % K == 0) {
                sb.append(q.poll() + ", ");
                cnt++;
            } else {
                // 아닐경우에는 popleft 하여 큐 맨뒤에 추가한다.
                q.add(q.poll());
                cnt++;
            }
        }
        sb.append(q.poll() + ">");
        System.out.println(sb);
        // 1, 2, 3, 4, 5, 6, 7
    }
}

// 1, 2 ,3 ,4 , 5, 6, 7
//