package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Line {
    int L;
    int R;

    Line(int L, int R) {
        this.L = L;
        this.R = R;
    }

    @Override
    public String toString() {
        return L + ", " + R;
    }
}

public class BJ_2042_선분덮기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Line> pq = new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if (o1.L == o2.L) {
                    return o2.R - o1.R;
                }

                return o1.L - o2.L;
            }
        });

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0) {
                break;
            }

            Line line = new Line(L, R);
            pq.offer(line);
        }

        int before_start = -1;
        int max_end = Integer.MIN_VALUE;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Line line = pq.poll();

            if (line.L == before_start) {
                continue;
            } else {
                before_start = line.L;
            }

            if (max_end < line.R) {
                if (line.L <= max_end) {

                }


                max_end = line.R;
                cnt++;
            } else {
                continue;
            }


        }
    }
}


// 1
// 0과 1을 완전히 덮자!
// 만약 R이 0보다 작다면? ㄴㄴ -1
// 만약 L가 M보다 크다면? ㄴㄴ 2
// 이전의 끝나는 지점보다 끝나는 지점이 커야한디.
// 이전의 끝나는 지점보다 시작지점이 같거나 작아야 한다.

// 5 -> 0 ~ 5 길이가 5다. 그 말은

// L R gap
// -1 0
// 0 3
// 0 2
// 1 4
// 3 5

// 3 5
// 1 4
// 0 3
// 0 2
// -1 0

//10
//0 1
//0 5
//2 4
//3 6
//4 8
//7 8
//7 10
//0 0