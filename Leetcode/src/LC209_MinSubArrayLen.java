public class LC209_MinSubArrayLen {
    /** 最短子数组长度*/
    //给定一个数组nums和一个整数s
    //找出这个数组中 sum>=s的最短子数组，并返回这个子数组的长度
    //如果没有找到就返回0

    public static int minSubArrayLen(int[] nums,int target){
        int result=Integer.MAX_VALUE;//为了初始比较时，更小的一定是另一个值
        int left=0;
        int sum=0;
        int all=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            all+=nums[right];
            while(sum>=target){//当满足条件时，更新result，同时缩小窗口
                result=Math.min(result,right-left+1);
                sum-=nums[left];
                left++;//sum窗口减小包括两件事：1.总和减小，left指针右移
            }
        }
        if(all<target){
            return 0;
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums={1,1,1,1,1,1,1,1};
        int target=11;
        int result=minSubArrayLen(nums,target);
        System.out.println(result);

    }
}
