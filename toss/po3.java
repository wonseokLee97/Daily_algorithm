package com.ssafy.toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class po3 {

    static String[] merchantNames;
    static int max_idx;

    public static void main(String[] args) {
        merchantNames = new String[]{
                "비바리퍼블리", "토스커피사일로 베이커리", "비바리퍼블리카 식당", "토스커피사일", "토스커피사일로 베이커", "비바리퍼블리카식", "토스커피사일로 베이", "토스커피사일로&베이커리", "토스커피사일로.베이커리"
//                "토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"
        };

        int max_len = Integer.MIN_VALUE;
        max_idx = Integer.MIN_VALUE;

        HashMap<String, Integer> map = new HashMap<>();

//        Arrays.sort(merchantNames);

        for (String merchantName : merchantNames) {
            String[] s = merchantName.split(" ");
            System.out.println(Arrays.toString(s));
        }

        String get = "";
        List<String> list = new ArrayList<>();


        for (String merchantName : merchantNames) {

            if (merchantName.contains(" ")) {
                String[] s = merchantName.split(" ");
            } else {

            }

            if (merchantName.length() > max_len) {
                max_len = merchantName.length();
                list.add(merchantName);
            } else if (merchantName.length() >= max_len) {
                if (merchantName.contains("&") || merchantName.contains("(") || merchantName.contains(")") || merchantName.contains(".") || merchantName.contains(",") || merchantName.contains("-")) {
                    max_len = merchantName.length();
                    list.remove(merchantName.replace("&", " "));
                    list.remove(merchantName.replace("(", " "));
                    list.remove(merchantName.replace(")", " "));
                    list.remove(merchantName.replace(".", " "));
                    list.remove(merchantName.replace("-", " "));

                    list.add(merchantName);
                }
            }
        }

//        System.out.println(list.toString());

    }
}
