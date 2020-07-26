
//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5

package leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        // ans = 7.0
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8}; // 8
        int[] nums2 = {3, 4, 9, 10, 11, 12, 13, 14, 17, 18}; // 10
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            // n1 should be smaller than n2
            if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
            int start = 0, end = n1, k = (n1 + n2 + 1) / 2;
            // use equation: i + j = (n1 + n2 + 1) / 2
            while (start < end) {
                int i = start + (end - start) / 2;
                int j = k - i; // this comes with the median equation
                if (nums1[i] < nums2[j - 1]) {
                    start = i + 1; // move right
                } else {
                    end = i; // move left
                }
            }
            int pos1 = start, pos2 = k - start;
            int v11 = pos1 == 0 ? Integer.MIN_VALUE : nums1[pos1 - 1];
            int v21 = pos2 == 0 ? Integer.MIN_VALUE : nums2[pos2 - 1];
            int v1 = Math.max(v11, v21);
            if (((n1 + n2) & 1) != 0) return v1;
            int v12 = pos1 == n1 ? Integer.MAX_VALUE : nums1[pos1];
            int v22 = pos2 == n2 ? Integer.MAX_VALUE : nums2[pos2];
            int v2 = Math.min(v12, v22);
            return (v1 + v2) / 2d;
        }

        // variation
        public double findKthElement(int[] nums1, int[] nums2, int k) {
            return 0d;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}