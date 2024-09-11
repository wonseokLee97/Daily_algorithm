package com.ssafy._2022_1._2022_10.day_221001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1249_보급로_이원석 {
	static int N, T, arr[][], cost[][],
	dx[] = {-1, 1, 0, 0}, 
	dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			cost = new int[N][N];

			for (int i = 0; i < N; i++) {
				char[] chars = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = chars[j] - '0';
				}
			}

			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], (int) 1e9);
			}
			cost[0][0] = 0;

			bfs(0, 0);
			System.out.printf("#%d %d\n" ,t ,cost[N - 1][N - 1]);
		}
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{a, b});
		
		while(!q.isEmpty()) {
			int[] get = q.poll();
			int x = get[0];
			int y = get[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 다음 경로에 이미 소모된 비용보다 지금 소모되는 비용이 더 적을경우만 큐에 넣는다.
				if (isIn(nx, ny)) {
					if (arr[nx][ny] + cost[x][y] < cost[nx][ny]) {
						cost[nx][ny] = arr[nx][ny] + cost[x][y];
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		if (0<=x && x<N && 0<=y && y<N) {
			return true;
		}
		return false;
	}
}

//4
//0 1 0 0
//1 1 1 0
//1 0 1 1
//1 0 1 0