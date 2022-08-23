package _18_4Sum;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        int slen = len - 2;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int a = 0; a <= slen - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int b = a + 1; b <= slen - 1; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                twoSum(nums, a, b, target - nums[a] - nums[b], res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int a, int b, int target, List<List<Integer>> res) {
        int len = nums.length;
        int c = b + 1, d = len - 1;
        while (c < d) {
            if (nums[c] + nums[d] == target) {
                res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                c++;
                while (c < d && nums[c] == nums[c - 1])
                    c++;
            } else if (nums[c] + nums[d] < target) {
                c++;
                while (c < d && nums[c] == nums[c - 1])
                    c++;
            } else if (nums[c] + nums[d] > target) {
                d--;
                while (c < d && nums[d + 1] == nums[d])
                    d--;
            }
        }
    }

    public static void main(String[]  args) {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        List<List<Integer>> res = new Solution().fourSum(nums, 0);
        System.out.println(res);
    }
}
