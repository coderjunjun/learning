package cn.junwork.algorithm.other.stack;

/**
 * Created by Jun on 2017/6/6.
 */
public class Hanoi {
    private int moveCount = 0;
    
    public int hanoi(int n) {
        move(n, 'A', 'B', 'C');
        return moveCount;
    }
    
    
    private void move(int n, char from, char buffer, char to) {
        if (n == 1) {
            System.out.println(from + " -> " + to);  ++moveCount;
            return;
        }
    
        move(n - 1, from, to, buffer);
        System.out.println(from + " -> " + to);  ++moveCount;
        move(n - 1, buffer, from, to);
    }
}
