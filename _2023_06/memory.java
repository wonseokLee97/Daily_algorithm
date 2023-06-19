package com.ssafy._2023_06;

import java.util.HashMap;
import java.util.Scanner;

public class memory {
    public static void main(String[] args) {

        // Garbage Collection으로 메모리 초기화
        System.gc();

        // 실행전 메모리 사용량 조회
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int[] arr = new int[100000];

        for (int i = 0; i < 100000; i++) {
            arr[i] = i;
        }

        String s = "";

        for (int i = 0; i < 100000; i++) {
            s += "asd";
            if (i % 2 == 0) {
                HashMap map = new HashMap();

                if (map.get(i) == null) {
                    map.put(i, i);
                }
            }
        }

        Runtime.getRuntime().gc();

        // Garbage Collection으로 메모리 정리
        System.gc();

        // 실행 후 메모리 사용량 조회
        long after  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 메모리 사용량 측정
        long usedMemory = (before - after)/1024/1024;
        System.out.println(before - after);

        System.out.println("Used Memory : " + usedMemory);



        // 애플리케이션에 할당돈 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM발생
        long heapSize = Runtime.getRuntime().maxMemory();
        System.out.println(heapSize/1024/1024);
    }
}
