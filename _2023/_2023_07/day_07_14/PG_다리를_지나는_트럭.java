package com.ssafy._2023._2023_07.day_07_14;

import java.util.*;

public class PG_다리를_지나는_트럭 {
    class TruckSolution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            int total = 0;
            int time  = 0;
            Queue<Integer> q = new LinkedList<>();

            for (int w : truck_weights) {

                while (true) {
                    // 다리위에 아무것도 없는 경우
                    if (q.size() == 0) {
                        total += w;
                        q.offer(w);
                        time++;
                        break;
                    }
                    // 다리에 꽉 찬 경우
                    else if (q.size() == bridge_length) {
                        total -= q.poll();
                    } else {
                        // 무게를 초과하는 경우
                        if (total + w > weight) {
                            // 일단 앞으로 보내야되니까 0을 넣음.
                            q.offer(0);
                            time++;
                        } else {
                            q.offer(w);
                            total += w;
                            time++;
                            break;
                        }
                    }
                }
            }

            answer = time + bridge_length;


            return answer;
        }
    }

// 다리를 건너는 트럭이 한 개인 경우(더 이상 못올리는 경우) 걸리는 시간은 다리의 길이만큼
// 다리를 건너는 트럭이 두 개 이상인 경우() 걸리는 시간은
}
