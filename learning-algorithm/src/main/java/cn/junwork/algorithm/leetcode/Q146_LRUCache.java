package cn.junwork.algorithm.leetcode;

import java.util.LinkedHashMap;

public class Q146_LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public Q146_LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
        if (this.size() > capacity) {
            Integer keyToDel = entrySet().iterator().next().getKey();
            this.remove(keyToDel);
        }
    }

    public static void main(String[] args) {
        Q146_LRUCache lRUCache = new Q146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        System.out.println(lRUCache);
    }
}
