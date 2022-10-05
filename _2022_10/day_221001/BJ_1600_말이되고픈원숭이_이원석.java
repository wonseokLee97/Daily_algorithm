package com.ssafy._2022_10.day_221001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 말
// 좌상1, 좌상2, 우상1, 우상2, 우하1, 우하2, 좌하1, 좌하2
// {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, 2}, {2, 1}, {2, -1}, {1, -2}

public class BJ_1600_말이되고픈원숭이_이원석 {
	static int 
	arr[][], 
	hx[] = {-1, -2, -1, -2, 1, 2, 2, 1}, 
	hy[] = {-2, -1, 2, 1, 2, 1, -1, -2}, 
	dx[] = {1, -1, 0, 0}, 
	dy[] = {0, 0, -1, 1},
	visited[][][],
	K,
	W, H,
	min_cnt = Integer.MAX_VALUE
	;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visited = new int[H][W][K + 1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// K번을 뛰기전에! 장애물이 있는지 확인한다.
		// 장애물이 없는 방향으로 뛰어버려
		
//		for (int[] a : arr) {
//			System.out.println(Arrays.toString(a));
//		}
		bfs(0, 0, 0);
	}
	
	public static void bfs(int i, int j, int kk) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j][kk] = 1;
		q.offer(new int[]{i, j, kk});

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			int k = poll[2];

			// 기저조건
			if (x == H - 1 && y == W - 1) {
				System.out.println(visited[x][y][k] - 1);
				return;
			}

			for (int l = 0; l < 4; l++) {
				int nx = x + dx[l];
				int ny = y + dy[l];

				if (0 <= nx && nx < H && 0 <= ny && ny < W && visited[nx][ny][k] == 0 && arr[nx][ny] == 0) {
					visited[nx][ny][k] = visited[x][y][k] + 1;
					q.offer(new int[]{nx, ny, k});
				}
			}

			if (k < K) {
				for (int l = 0; l < 8; l++) {
					int nx = x + hx[l];
					int ny = y + hy[l];

					if (0 <= nx && nx < H && 0 <= ny && ny < W && visited[nx][ny][k + 1] == 0 && arr[nx][ny] == 0) {
						visited[nx][ny][k + 1] = visited[x][y][k] + 1;
						q.offer(new int[]{nx, ny, k + 1});
					}
				}
			}
		}

		System.out.println(-1);
		return;
	}

	
	
	public static boolean isIn(int nx, int ny) {
		// 범위를 벗어나지 않는다면,
		if (0 <= nx && nx < H && 0 <= ny && ny < W) {
			return true;
		}
		return false;
	}
	
	public static boolean noDis(int nx, int ny) {
		// 이동한 곳에 장애물이 없다면,
		if (arr[nx][ny] == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean noVis(int nx, int ny, int k) {
		// 이동한 곳을 방문하지 않았다면,
		if (visited[nx][ny][k] == 0) {
			return true;
		}
		return false;
	}
}


//2
//5 5
//0 0 0 0 0
//1 0 0 0 0
//0 0 1 0 0
//0 1 0 0 0
//0 0 0 0 0
