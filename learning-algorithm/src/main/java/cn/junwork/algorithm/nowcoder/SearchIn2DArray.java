package cn.junwork.algorithm.nowcoder;

/**
 * <a href="https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">二维数组中的查找</a>
 * <pre>
 *     在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </pre>
 */
public class SearchIn2DArray {
    
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        
        int colCount = array[0].length, rowCount = array.length;
        int row = 0, col = 0;
        int direction = 1; //搜索方向，1为从左至右，-1为从右至左
    
        while (row < rowCount) {
            if (array[row][0] <= target && target <= array[row][colCount - 1]) {
                while (col < colCount && direction * array[row][col] < direction * target) {
                    col += direction;
                }
                if (array[row][col] == target) return true;
                direction = -direction;
            }
            ++row;
        }
    
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new SearchIn2DArray().Find(8, new int[][]{
                {0, 5, 10, 15}, 
                {1, 6, 11, 16}, 
                {2, 7, 12, 17}, 
                {3, 8, 13, 18}, 
        }));
    }
}
