package cn.junwork.algorithm.leetcode;

/**
 * There are N students in a class. Some of them are friends,
 * while some are not. Their friendship is transitive in nature. For example,
 * if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other,
 * otherwise not. And you have to output the total number of friend circles among all the students.
 * <pre>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * </pre>
 */
public class Q547_FriendCircles {

    /**
     * DFS方法
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        //标记一个人是否有朋友圈，同时也作为DFS的访问标记
        int[] circleFlag = new int[200];
        //朋友圈数量
        int count = 0;

        for (int p = 0; p < M.length; ++p) {
            if (circleFlag[p] == 0) { //这个人还没有朋友圈
                ++count;
                //搜寻出这个人的所有朋友
                findFriends(M, circleFlag, p);
            }
        }

        return count;
    }


    /**
     * DFS搜寻某人的所有朋友
     *
     * @param M
     * @param circleFlag
     * @param p
     */
    private void findFriends(int[][] M, int[] circleFlag, int p) {
        if (circleFlag[p] == 1) return;

        circleFlag[p] = 1;
        for (int i = 0; i < M[p].length; ++i) {
            if (M[p][i] > 0) {
                findFriends(M, circleFlag, i);
            }
        }
    }


    /**
     * 并查集（Union-Find）方法
     * @param M
     * @return
     */
    public int findCircleNum1(int[][] M) {
        //分组个数
        int count = M.length;
        //用来记录每个节点所在的组号
        int[] groups = new int[M.length];
        //初始时，我们设置每个节点的组号为节点号本身
        //也就是每个节点自成一个组
        for (int i = 0; i < groups.length; ++i) {
            groups[i] = i;
        }

        //遍历所有边
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[i].length; ++j) {
                if (M[i][j] > 0) { //节点i与节点j相连，说明它们应该属于同一组
                    if (groups[i] != groups[j]) { //这两个节点不在同一组（Find操作）
                        //合并到同一个组（Union操作）
                        //那么，所有跟i在同一组的节点都要改组号
                        int oldGroup = groups[i];
                        int newGroup = groups[j];
                        for (int k = 0; k < groups.length; ++k) {
                            if (groups[k] == oldGroup) {
                                groups[k] = newGroup;
                            }
                        }

                        //每合并一次，分组个数减1
                        --count;
                    }
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Q547_FriendCircles f = new Q547_FriendCircles();

        int[][] a = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[][] b = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int[][] c = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        System.out.println(f.findCircleNum(a));
        System.out.println(f.findCircleNum(b));
        System.out.println(f.findCircleNum(c));

        System.out.println("=======================");

        System.out.println(f.findCircleNum(a));
        System.out.println(f.findCircleNum(b));
        System.out.println(f.findCircleNum(c));
    }
}
