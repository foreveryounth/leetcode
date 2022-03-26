package _11_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxCapacity = 0;
        while (l < r) {
            int curCapacity = Math.min(height[l], height[r]) * (r - l);
            maxCapacity = Math.max(maxCapacity, curCapacity);
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxCapacity;
    }
}
