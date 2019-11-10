package cn.junwork.algorithm.other.bit;

/**
 * <p>
 *     一组数字中，每个数字都出现1次，只有一个数字出现2次，找出这个数字
 * </p>
 * <p>
 *     要求：时间复杂度O(n)，空间复杂度小于O(n)
 * </p>
 *
 * @author chenjun1@corp.netease.com
 * @date 2019/1/10
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int flag = 0;

        for (int i = 0; i < nums.length; i ++) {
            flag ^= nums[i];
        }
        for (int i = 1; i < nums.length; i ++) {
            flag ^= i;
        }

        return flag;
    }
}
