package cn.jimyoung.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        int b1 = 1;
        int b2 = 1;
        int b3 = 1;
        int b4 = 1;
        if (false && ++b1 == 2) {
            System.out.println("if通过1");
        }
        System.out.println("b1: " + b1);
        if (false & ++b2 == 2) {
            System.out.println("if通过2");
        }
        System.out.println("b2: " + b2);
        if (true || ++b3 == 2) {
            System.out.println("if通过3");
        }
        System.out.println("b3: " + b3);
        if (true | ++b4 == 2) {
            System.out.println("if通过4");
        }
        System.out.println("b4: " + b4);
    }
}