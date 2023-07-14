package com.ssafy._2023_07.day_07_14;

import java.util.*;

public class PG_주차요금계산 {
    static int end_time = 23 * 60 + 59;

    class ParkingSolution {
        public int[] solution(int[] fees, String[] records) {
            int[] result = {};

            int baseTime = fees[0];
            int baseFee = fees[1];
            int unitTime = fees[2];
            int unitFee = fees[3];

            HashMap<String, Integer> map = new HashMap<>();
            HashMap<String, Integer> cost = new HashMap<>();
            List<String> carNums = new ArrayList<>();

            for (String r : records) {
                String[] record = r.split(" ");
                String[] inTime = record[0].split(":");

                int entrance = Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]);

                // 번호판 모아
                if (!carNums.contains(record[1])) {
                    carNums.add(record[1]);
                }

                // 입차라면
                if (record[2].equals("IN")) {
                    map.put(record[1], entrance);
                }
                // 출차라면
                else {
                    int gap = entrance - map.get(record[1]);
                    map.remove(record[1]);

                    if (cost.get(record[1]) == null) {
                        cost.put(record[1], gap);
                    } else {
                        cost.put(record[1], cost.get(record[1]) + gap);
                    }
                }
            }

            for (String m : map.keySet()) {
                int get = map.get(m);

                if (cost.get(m) == null) {
                    cost.put(m, (end_time - map.get(m)));
                } else {
                    cost.put(m, cost.get(m) + (end_time - map.get(m)));
                }
            }


            Collections.sort(carNums);

            result = new int[carNums.size()];

            for (String carNum : carNums) {
                int sum = cost.get(carNum);

            }

            for (int i = 0; i < carNums.size(); i++) {
                int sum = cost.get(carNums.get(i));

                if (sum <= baseTime) {
                    result[i] = baseFee;
                    continue;
                }

                int tmp = (int) Math.ceil((float) (sum - baseTime) / unitTime);
                result[i] = baseFee + tmp * unitFee;
            }

            return result;
        }
    }
}
