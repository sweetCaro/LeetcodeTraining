public class LC704_BinarySearch {
    public static int search(int[] nums, int target){
/**      空间复杂度=O(n)的暴力解法
 * for (int i=0;i<nums.length;i++){
 *            if (nums[i]==target){
 *               return i;
 *            }
 *         }
 */

        int left = 0;
        int right = nums.length - 1;
        if(target<nums[0]||target>nums[nums.length-1]){
            return -1;
        }
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]>target){
                right=middle-1;
            }
            else if(nums[middle]<target){
                left=middle+1;
            }
            else{
                return middle;
            }
        }
        return -1;
        /**
         * 首先判断target值不比nums[0]小，也不比nums[nums.length-1]大；
         *
         * 初始定义left=0，right=数组最后一个有效元素；
         *
         * 循环条件是left≤right（因为定义的是左闭右闭区间，当left=right时，区间仍有效）；
         *
         * 定义middle是left到right的中间坐标；
         *
         * 判断nums[middle]和target哪个更大：
         *
         * 如果nums[middle]大说明target在左半区间→缩小到左半区间查找→right=middle-1；
         *
         * 如果nums[middle]小说明target在右半区间→缩小到右半区间查找→left=middle+1;
         *
         * （因为middle上的值已经判断过不是target了，且定义的是左闭右闭区间，即两个边界值都能取到，所以跳过middle上的值就好，否则会多判断一个数字）
         *
         * 如果nums[middle]==target，返回middle；
         *
         * 若循环结束都没有找到说明target不在数组里，返回-1。
         */
    }
    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        int target=12;
        System.out.println(search(nums, target));
    }
}
