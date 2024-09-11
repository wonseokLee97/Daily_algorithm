package com.ssafy._2022_1.day_220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D3_1225_암호생성기_이원석 {
    static Queue<Integer> q; // static queue
    static int cycle;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // for TC
        for (int t = 1; t < 11; t++) {
            int T = Integer.parseInt(br.readLine()); // garbage value
            q = new LinkedList<>();

            StringBuilder sb = new StringBuilder("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            // cycling 시작
            cycling();

            // 암호로 변환된 q를 출력
            while (!q.isEmpty()) {
                int poll = q.poll();
                sb.append(poll + " ");
            }
            System.out.println(sb);
        }
    }
    public static void cycling() {
        // 무한반복한다
        while (true) {
            // cycle 의 초기값은 1
            cycle = 1;

            // cycle 은 최대 5까지 상승한다.
            for (int i = 0; i < 5; i++) {
                int pop_left = q.poll();

                // pop_left 값과 cycle 값의 차가 0보다 작다면, 오른쪽에 0을 추가한다.
                // 그리고 조건에 따라 해당 배열을 반환한다.
                if (pop_left - cycle <= 0) {
                    q.add(0);
                    return;
                } else { // 그렇지않다면 그냥 추가한다.
                    q.add(pop_left - cycle);
                }

                cycle++; // cycle 증가
            }
        }
    }
}

