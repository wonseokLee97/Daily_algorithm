package com.ssafy._2022_1.day_220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_12712_파리퇴치_이원석 {
    static int M;
    static int N;
    static int[][] arr;
    static int[] dx1 = {-1, 1, 0, 0};
    static int[] dy1 = {0, 0, -1, 1};
    static int[] dx2 = {-1, 1, -1, 1};
    static int[] dy2 = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        // 입출력 관리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // TC
        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N]; // 배열
            int max_val = Integer.MIN_VALUE; // 최대값을 저장할 변수

            // 입력값을 통해 배열 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 배열을 순회하며
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 해당 좌표에서 +, x형 분사중 어느게 더 많은 결과값이 나오는지를 확인하여
                    // 최대값을 저장하는 변수에 저장한다.
                    max_val = Math.max(max_val, Math.max(spray1(i, j), spray2(i, j)));
                }
            }

            // 출력
            StringBuilder sb = new StringBuilder("");
            sb.append("#");
            sb.append(t + " ");
            sb.append(max_val);

            System.out.println(sb);
        }
    }
    // +형 분사
    public static int spray1 (int x, int y){
        int nx;
        int ny;
        int sum = 0;

        // M(사거리)만큼 반복한다
        for (int k = 1; k < M; k++) {
            for (int l = 0; l < 4; l++) {
                // 4방향을 순회하며 잡은 파리의 값을 저장한다
                // k(사거리) 값을 곱해주어 사거리를 범위제한 까지 점점 넓혀간다.
                // dx1은 +형 분사
                nx = x + k * dx1[l];
                ny = y + k * dy1[l];

                // 해당 분사가 배열의 범위를 벗어나지 않는다면,
                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                    // 결과값에 추가한다.
                    sum += arr[nx][ny];
                }
            }
        }
        return sum + arr[x][y];
    }

    // x형 분사
    public static int spray2 (int x, int y){
        int nx;
        int ny;
        int sum = 0;

        // M(사거리)만큼 반복한다
        for (int k = 1; k < M; k++) {
            for (int l = 0; l < 4; l++) {
                // 4방향을 순회하며 잡은 파리의 값을 저장한다
                // k(사거리) 값을 곱해주어 사거리를 범위제한 까지 점점 넓혀간다.
                // dx2는 x형 분사
                nx = x + k * dx2[l];
                ny = y + k * dy2[l];

                // 해당 분사가 배열의 범위를 벗어나지 않는다면,
                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                    // 결과값에 추가한다.
                    sum += arr[nx][ny];
                }
            }
        }
        return sum + arr[x][y];
    }
}
