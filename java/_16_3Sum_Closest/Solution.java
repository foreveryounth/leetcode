package _16_3Sum_Closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int a = 0; a < len; a++) {
            //while (a < len - 1 && nums[a] == nums[a + 1])
            //  a++;
            int b = a + 1, c = len - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;

                if (sum < target) {
                    b++;
                    while (b < c && nums[b] == nums[b - 1])
                        b++;
                } else if (sum > target) {
                    c--;
                    while (b < c && nums[c] == nums[c + 1])
                        c--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
