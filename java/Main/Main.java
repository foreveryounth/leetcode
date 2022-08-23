package Main;
import _16_3Sum_Closest.Solution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void  main(String[] args){
        Solution solution = new Solution();
        int[] input = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        System.out.println(solution.threeSumClosest(input, 0));
    }
}
