package com.ssafy;

import java.util.*;

abstract class Vehicle {

    String name;
    abstract public String getName(String val);

    public String getName() {
        return "Vehicle name: " + name;
    }
}


interface Vehicle2 {
    
    int name = 0;

    void test();
    abstract void test2();
}


class Car extends Vehicle {

    public Car(String val) {
        name=super.name=val;
    }

    public String getName(String val) {
        return "Car name:" + val;
    }

    public String getName(byte val[]) {
        return "Car name:" + val;
    }
}


public class test {
    public static void main(String[] args) {
        int n;
        int k;
        int s;
        int el = 0;

        for(n=6; n<=30; n++){
            s=0;
            k=n/2;
            for(int j=1; j<=k; j++){
                if(n%j==0){
                    s=s+j;
                }
            }
            if(s==n){
                System.out.println(n);
                el++;
            }
        }

        System.out.printf("%d", el);

    }
}