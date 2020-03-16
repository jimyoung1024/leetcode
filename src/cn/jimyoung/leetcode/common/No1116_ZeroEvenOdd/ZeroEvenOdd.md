# No1116 ZeroEvenOdd

## 方法1
使用Semaphore信号量，为每一个函数设置一个独立的信号量
```java
Semaphore z = new Semaphore(1);//对应Zero
Semaphore e = new Semaphore(0);//对应Even
Semaphore o = new Semaphore(0);//对应Odd

```
这样保证了首先打印0，然后对zero函数做下面这样的处理
```java
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<n;i++) {
        	z.acquire();
        	printNumber.accept(0);
            //i是偶数的时候释放信号量o，这样才能保证输出0后再输出1
        	if((i&1)==0) {
        		o.release();
        	}else {
        		e.release();
        	}
        }
    }
```
## 方法2
见代码，思路与上面差不多，相当于自己借助逻辑来判断何时该释放锁

