package com.ssafy.day_220824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/* MST : 프림 알고리즘 이용 */
public class MST2_Prim {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        //--
        int N = Integer.parseInt(in.readLine().trim());	
        int[][] input = new int[N][N];          // 정점 크기 만큼 인접행렬
        boolean[] visited = new boolean[N];     // 신장트리 선택 여부 채킹
        int[] minEdge = new int[N];             // 신장트리에 포함된 정점으로 부터 자신과 연결하는 간선비용중 최소비용


        // 1 2 1 -> arr[1][2] = 1 ,  arr[2][1] = 1
        // 2 3 2 -> arr[2][3] = 2 ,  arr[3][2] = 2
        // 1 3 3 -> arr[1][3] = 3 ,  arr[3][1] = 3


        //-- 인접행렬 input 초기화
        StringTokenizer tokens;
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(in.readLine(), " "); 
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
            // 최소값 구하기
            minEdge[i] = Integer.MAX_VALUE;
        }

        System.out.println(Arrays.toString(minEdge));
        
        //--
        int minVertex, min; // 최소정점, 최소정점의 간선 비용
        int result = 0; 	// MST 비용
        minEdge[0] = 0; 	// 임의의 시작점 비용으로 초기화 설정


        //-- 1단계 : 정점 중심 해결 : 모든 정점수만큼 반복하면서 모든 정점을 연결
		for(int c = 0 ; c < N; c++){
            min = Integer.MAX_VALUE; // 초기값을 최대값으로 설정
            minVertex = 0;           // 임의값 설정.

            //-- N개의 정점 반복하면서 가장 유리한(최소비용) 정점 선택
            for(int i = 0; i < N; ++i) {
                if (!visited[i] && min > minEdge[i]) {  // 현재 간선의 최대값이 다음 간선보다 크다면!?
                    min = minEdge[i];   // 다음 간선이 최소값
                    minVertex = i;        // 그리고 그 현재의 정점으로 최소정점을 설정한다.
                }
            }

            System.out.println(min + ", " + minVertex);
            System.out.println(Arrays.toString(minEdge));
            visited[minVertex] = true;  // 선택된 정점 방문표시
            result += min;              // 선택된 정점을 MST에 누적한다.


            //-- 2단계:
            // 선택된 최소비용 정점과 신장트리 구성에 포함되지 않은 타정점으로의 최소 비용 갱신
            for (int i = 0; i < N; i++) { 
                if (!visited[i]                                     // 방문하지 않고!
                	&& input[minVertex][i] != 0                     // 인접해 있고,
                	&& minEdge[i] > input[minVertex][i] ) {         //
                    // 정점에서 다음정점에서 자신한테 연결하려할 때, 간선의 최소비용이 크다면 갱신
                	minEdge[i] = input[minVertex][i];               // 가장 유리한 비용으로 객싱
                }
            }

        }
		
        System.out.println(result);
    }
}

