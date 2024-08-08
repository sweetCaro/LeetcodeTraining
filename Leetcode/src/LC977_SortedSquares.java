import java.util.Arrays;

import static java.util.Arrays.sort;

public class LC977_SortedSquares {
    public static int[] sortedSquares(int[] nums){
    /**最直观的想法，莫过于：每个数平方之后，排个序，代码如下：*/
    /**
     *  int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = nums[i]*nums[i];
        }
        sort(result, 0, nums.length-1);
        return result;
     */

    /**
     * 数组其实是有序的， 只不过负数平方之后可能成为最大数了。
     *
     * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
     *
     * 此时可以考虑双指针法了，left指向起始位置，right指向终止位置。
     *
     * 定义一个新数组result，和nums数组一样的大小，让index指向result数组终止位置。
     *
     * 如果nums[left]*nums[left]>nums[right]*nums[right]
     * 那么result[index--] = nums[left] * nums[left]; 。
     *
     * 如果nums[left]*nums[left]<nums[right]*nums[right]
     * 那么result[index--] = nums[right] * nums[right]; 。
     */
        int right=nums.length-1;
        int left=0;
        int index=nums.length-1;
        int result[]=new int[nums.length];
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                result[index]=nums[left]*nums[left];
                index--;
                left++;

            }
            else{
                result[index]=nums[right]*nums[right];
                index--;
                right--;

            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums={-2,1,8,11};
        int[] sortedSquares=sortedSquares(nums);
        System.out.println(Arrays.toString(sortedSquares));
    }
}
