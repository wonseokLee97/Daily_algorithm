package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class C {
    int S;
    int T;

    C(int s, int t) {
        S = s;
        T = t;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("C{");
        sb.append("S=").append(S);
        sb.append(", T=").append(T);
        sb.append('}');
        return sb.toString();
    }
}

public class BJ_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        C[] arr = new C[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr[i] = new C(S, T);
        }

        Arrays.sort(arr, new Comparator<C>() {
            @Override
            public int compare(C o1, C o2) {
                if (o1.S == o2.S) {
                    return o1.T - o2.T;
                }

                return o1.S - o2.S;
            }
        });

        pq.offer(arr[0].T);

        for (int i = 1; i < N; i++) {
            // 현재 가장 빨리 끝나는 타임과 같은 강의실을 쓸 수 있는 경우
            if (pq.peek() <= arr[i].S) {
                // 해당 강의실에 끝나는 시간을 변경
                pq.poll();
            }

            // 강의 종료시간 추가
            pq.offer(arr[i].T);
        }

        System.out.println(pq.size());
    }
}

//4
//1 3
//1 2
//2 4
//3 5
//C{S=3, T=5}
//C{S=2, T=4}
//C{S=1, T=3}


// Sj가 Ti보다 작은 경우에는 강의실을 분리한다.
// Sj가 Ti보다 같거나 크다면 강의실을 포함한다.
// 1   3
// 1 2
//   2   4
//     3   5

//4
//1 2
//1 3
//3 5
//2 10

// 1 2
//   2              10
// 1   3
//     3   5

// Sj가 Ti보다 같거나 큰 경우로 정렬해라.


// 1     4
//   2 3
//     3    5

// 1   3
//     3   5
//   2   4