package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel {
    int M;
    int V;

    Jewel(int M, int V) {
        this.M = M;
        this.V = V;
    }

    @Override
    public String toString() {
        return M + ", " + V;
    }
}

public class BJ_1201_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] j_arr = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            j_arr[i] = new Jewel(M, V);
        }

        Arrays.sort(j_arr ,new Comparator<Jewel>() {
            @Override
            public int compare(Jewel j1, Jewel j2) {
                // 무게의 오름차순이되, 무게가 같다면 비싼순
                // 같은 무게라면 더 가치가 높은 녀석
                if (j2.M == j1.M) {
                    return j2.V - j1.V;
                }

                return j1.M - j2.M;
            }
        });

        Integer[] bag = new Integer[K];

        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }

        Arrays.sort(bag);

        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;

        for (int i = 0; i < K; i++) {
            // 보석이 수용가능한 무게라면 pq에 넣자.
            while (idx < N && j_arr[idx].M <= bag[i]) {
                pq.offer(j_arr[idx++].V);
            }
//            System.out.println(bag[i] + ", " + pq);

            // 현재 pq 중에서 가장 가치가 큰 놈을 꺼내자. (어짜피 수용가능한 무게만 있다.)
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}



// 보석은 한 개밖에 못 넣는다! 가장 가치있는 보석을 넣어야 해
// 가장 가벼운 무게인데 값 비싼놈이 필요해

// 보석의 개수: N
// 보석의 무게: M
// 보석의 가격: V
// 상덕이의 가방: K
// 수용 최대 무게: C (최대 한 개만 넣을 수 있음)

//5 2
//1 65
//5 23
//2 99
//3 99
//4 99
//10
//2

//4 4
//1 100
//2 200
//13 300
//10 500
//10
//10
//10
//14

//9 5

// 183
//4 10
//4 9
//4 5
//8 55
//8 55
//8 5
//9 15
//11 54
//14 20



//10
//5
//4
//15
//20

//
// 가방: 4 5 10 15 20
