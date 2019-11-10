package cn.junwork.algorithm.nowcoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    
    
    /**
     * <pre>
     * n级台阶，我们考虑最后一跳：
     * 如果最后一跳是n，那么转换为求（n-n）级台阶有多少种跳法，我们这里0阶台阶应当是1种跳法
     * 如果最后一跳是n-1，那么转换为求（n-n+1）级台阶有多少种跳法，显然1级台阶的跳法只有1种
     * 以此类推可得：Sn = S0 + S1 + S2 +...+ Sn-1
     * 
     * 其实，进一步观察可以发现 S0 + S1 + ... Sn-2 = Sn-1
     * 因此Sn = 2Sn-1 = 2^(n-1) * S0 = 2^(n-1)，n > 1
     * </pre>
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int n = 1; n <= target; ++n) {
            for (int i = 0; i < n; ++i) {
                dp[n] += dp[i];
            }
        }
        
        return dp[target];
    }
    
    
    public static void main(String[] args) {
        System.out.println(new JumpFloor().JumpFloorII(60));
    }
}
