package com.ssafy._2022_1.day_220819;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열,
public class D4_3234_준환이의양팔저울_이원석 {
    static int N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] visited = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int get = Integer.parseInt(st.nextToken());
                arr[i] = get;
            }

            perm(0, visited, arr, 0, 0);
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static void perm(int cnt, int[] visited, int[] arr, int left, int right) {
        // 모든 추를 다 사용했거나, 왼쪽이 더 커지는 경우에는 return
        if (left < right) {
            return;
        }
        if (cnt == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            perm(cnt + 1, visited, arr, left + arr[i], right);
            perm(cnt + 1, visited, arr, left, right + arr[i]);
            visited[i] = 0;
        }
    }
}

// R /
// L / 1 2 4

// R / 1
// L /   2 4

// R /   2
// L / 1   4

// R /     4
// L / 1 2

// R / 1 2
// L /     4

// R / 1   4
// L /   2

// R /   2 4
// L / 1

// R / 1 2 4
// L /


//        if (cnt == i) {
//            recur++;
//            System.out.println(Arrays.toString(visited2));
//            int right_sum = 0;
//            int left_sum = 0;
//            for (int j = 0; j < visited2.length; j++) {
//                if (visited2[j] == 1) { // 오른쪽에 놓을 추를 고른다.
//                    if (left_sum < check[j] + right_sum) {
//                        // 추를 놓았을 때, 오른쪽 저울의 무게가 더 무거워진다면,
//                        return;
//                    } else {
//                        right_sum += check[j];
//                    }
//                } else { // 왼쪽에 놓을 추를 골라 놓는다.
//                    left_sum += check[j];
//                }
//            }
//            // left_side >= right_side
//            if (left_sum >= right_sum) {
//                result++;
//            }
//            return;
//        }

//        for (int j = start; j < N; j++) {
//            if (visited2[j] == 1) {
//                continue;
//            }
//
//            visited2[j] = 1;
//            right_side(cnt + 1, j + 1, i);
//            visited2[j] = 0;
//        }


// R /
// L / 1 2 4

// R / 1
// L /   2 4

// R /   2
// L / 1   4

// R /     4
// L / 1 2

// R / 1 2
// L /     4

// R / 1   4
// L /   2

// R /   2 4
// L / 1

// R / 1 2 4
// L /


