package com.ssafy._2024_08.BJ_15787_기차가어둠을헤치고은하수를;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] train = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1 || a == 2) {
                int c = Integer.parseInt(st.nextToken()) - 1;

                if (a == 1) {
                    // c번째 자리에 승차.
                    train[b] |= (1 << c);
                } else {
                    // c번째 자리에 있는 사람 하차.
                    train[b] &= ~(1 << c);
                }
            } else {
                // 0001 - 1
                // 1000 - 1 << 3
                if (a == 3) {
                    // 맨 뒤사람 하차시키기.
                    train[b] = train[b] & ~(1 << 19);
                    // 한칸씩 뒤로
                    train[b] <<= 1;
                } else {
                    // 맨 앞사람 하차시키가.
                    train[b] = train[b] & ~1;
                    // 한칸씩 앞으로.
                    train[b] >>= 1;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int val : train) {
            set.add(val);
        }

        System.out.println(set.size());
    }
}


// 1 i x :
// i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라.
// 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.

// 2 i x :
// i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면,
// 아무런 행동을 하지 않는다.

// 3 i :
// i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다.
// k번째 앉은 사람은 k+1번째로 이동하여 앉는다.
// 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.

// 4 i :
// i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다.
// k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다.
// 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.


// 5 5
// [0, 0, 0, 0, 0, ... 0, 0]

// 1 1 1
// [1, 0, 0, 0, 0, ... 0, 0]

// 1 1 2
// [1, 1, 0, 0, 0, ... 0, 0]

// 1 2 2
// [0, 1, 0, 0, 0, ... 0, 0]

// 1 2 3
// [0, 1, 1, 0, 0, ... 0, 0]

// 3 1
// [0, 1, 1, 0, 0, ... 0, 0]