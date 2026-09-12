package arrays.assignment_problems;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println(Arrays.deepToString(res1));
        
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println(Arrays.deepToString(res2));
    }

    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] temp = new int[n * n][3];
        int count = 0;
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    temp[count][0] = nums[i];
                    temp[count][1] = nums[left];
                    temp[count][2] = nums[right];
                    count++;
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        int[][] result = new int[count][3];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}
