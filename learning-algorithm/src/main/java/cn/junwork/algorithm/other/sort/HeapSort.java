package cn.junwork.algorithm.other.sort;

/**
 * 堆排序
 * <p>
 * 思想：
 * <p>
 * 1.以元素为节点构造一颗完全二叉树，然后将整棵树“堆化”，即父节点的值 >= 两个子节点的值（大顶堆）。
 * <p>
 * 2.一轮下来，最大的元素就处于root位置，此时取出这个最大值，并将最后一个叶子节点提上来，然后递归的调整子树以保持堆的结构（就像插入排序）。
 * <p>
 * 3.重复2的操作，直到树只剩1个节点。
 * <p>
 * 另外，将一个数组作为完全二叉树来处理非常简单。假设某一节点的索引为i，那它左孩子的索引为2i + 1，右孩子的索引为2i + 2。
 * 我们把数组第一个元素作为root节点。
 */
public class HeapSort {
    
    public static void sort(int[] arr) {
        //首先对树进行“堆化”
        heapify(arr);
        
        for (int i = arr.length - 1; i > 0; --i) {
            //root节点和最后的叶子节点交换，也就是找出了本轮的最大值
            swap(arr, 0, i);
            //从root处重新调整
            adjust(arr, i, 0);
        }
    }
    
    
    /**
     * 对整棵树做“堆化”操作，实际上就是从下往上做调整操作
     *
     * @param tree
     */
    private static void heapify(int[] tree) {
        //root初始为最后一个非叶子节点  
        for (int root = tree.length / 2 - 1; root >= 0; --root) {
            adjust(tree, tree.length, root);
        }
    }
    
    
    /**
     * 从root处，递归的对子树进行调整，以满足堆的结构
     * <p>
     * <b>注意：调用方法前，root的子树必须已经满足堆的结构</b>
     *
     * @param tree 存储完全二叉树的数组
     * @param n    节点个数
     * @param root root的索引
     */
    private static void adjust(int[] tree, int n, int root) {
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        int largest = root; //我们先假设root节点的值最大
    
        if (leftChild < n && tree[leftChild] > tree[largest]) largest = leftChild;
        if (rightChild < n && tree[rightChild] > tree[largest]) largest = rightChild;
    
        //如果不是root节点的值最大
        if (largest != root) {
            //先交换
            swap(tree, root, largest);
            //此时，largest索引那边的堆结构被破坏，重新调整
            adjust(tree, n, largest);
        }
    }
    
    
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
