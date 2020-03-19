package cn.jimyoung.leetcode.common.No1116_ZeroEvenOdd;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int num = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (num % 2 != 0) {
                    this.wait();
                }
                printNumber.accept(0);
                num++;
                this.notifyAll();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int j = 2; j <= n; j = j + 2) {
            synchronized (this) {
                while (num % 2 == 0 || num % 4 != 3) {
                    this.wait();
                }
                printNumber.accept(j);
                num++;
                this.notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int j = 1; j <= n; j = j + 2) {
            synchronized (this) {
                while (num % 2 == 0 || num % 4 != 1) {
                    this.wait();
                }
                printNumber.accept(j);
                num++;
                this.notifyAll();
            }
        }
    }
}
