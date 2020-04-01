package cn.jimyoung.leetcode.common.No146_LRU缓存机制;

class LRUCache {
    final int CAPACITY;
    int currentCapacity = 0;
    int[][] table;

    public LRUCache(int capacity) {
        //第一行是key(-1代表该位置为空)，第二行是value，第三行是其未被使用的时间time
        table = new int[3][capacity];
        this.CAPACITY = capacity;
        for (int i = 0; i < CAPACITY; i++) {
            table[0][i] = -1;
        }
    }

    public int get(int key) {
        int index = search(key);
        if (index == -1) {
            return -1;
        } else {
            oldAll();
            //更新其未被使用的时间
            table[2][index] = 0;
            return table[1][index];
        }
    }

    public void put(int key, int value) {
        int index = search(key);
        oldAll();
        if (index == -1) {
            if (currentCapacity < CAPACITY) {
                for (int i = 0; i < CAPACITY; i++) {
                    if (table[0][i] == -1) {
                        table[0][i] = key;
                        table[1][i] = value;
                        table[2][i] = 0;
                        currentCapacity++;
                        return;
                    }
                }
                System.out.println("PUT ERROR");
            } else {
                int i = deleteOldest();
                table[0][i] = key;
                table[1][i] = value;
                table[2][i] = 0;
                currentCapacity++;
            }
        } else {
            table[1][index] = value;
            table[2][index] = 0;
        }
    }

    public void oldAll() {
        for (int i = 0; i < CAPACITY; i++) {
            table[2][i]++;
        }
    }

    /**
     * @param key 要查询的密钥
     * @return 目标的下标，如果不存在返回则返回-1
     */
    public int search(int key) {
        for (int i = 0; i < CAPACITY; i++) {
            if (table[0][i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return 被删除存储单元的下标
     */
    public int deleteOldest() {
        int indexOfOldest = 0;
        for (int i = 0; i < CAPACITY; i++) {
            if (table[2][i] > table[2][indexOfOldest]) {
                indexOfOldest = i;
            }
        }
        table[0][indexOfOldest] = -1;
        currentCapacity--;
        return indexOfOldest;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}