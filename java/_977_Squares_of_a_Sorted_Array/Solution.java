package _977_Squares_of_a_Sorted_Array;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return new int[]{nums[0]*nums[0]};
        int noNegativeIndex = 0;
        while (noNegativeIndex < len && nums[noNegativeIndex] < 0) {
            noNegativeIndex++;
        }

        int p1 = noNegativeIndex - 1;
        int p2 = noNegativeIndex;

        int[] ans = new int[len];
        int index = 0;
        while (p1 >= 0 && p2 < len) {
            int n1 = Math.abs(nums[p1]), n2 = nums[p2];
            if (n1 <= n2) {
                ans[index] = n1*n1;
                p1--;
            } else {
                ans[index] = n2*n2;
                p2++;
            }
            index++;
        }

        if (p1 < 0) {
            for (;index < len; index++, p2++)
                ans[index] = nums[p2]*nums[p2];
        } else {
            for (;index < len; index ++, p1--)
                ans[index] = nums[p1]*nums[p1];
        }

        return ans;
    }
}
