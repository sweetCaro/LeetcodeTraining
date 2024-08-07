import static java.util.Arrays.sort;

public class LC27_RemoveElement {
    public static int removeElement(int[] nums, int val) {

//        原地移除，意味着该元素会被后一个元素替代
//        第一次出现val的时候，直接让从后遍历的那个元素替代刚出现的val值，然后右边界缩小，左边界不动
//        那有可能出现刚替代的那个元素也是val值，没关系，因为不满足左边界值不是val（就是左边界等于val）的话，left不会前进
//        一直缩小右边界直到非val值的出现，赋给左边界后，左边界才会满足不是val的条件，实现left++
//        同时，left的值就是所有非val值的个数，即k
//
//        简单来说就是，左边界一开始发现了val值之后，就想让右边界扔点非val值，自己才能前进
//        那如果右边界扔的一直是val值，左边界就无法前进，是右边界一直在缩小
//        如果右边界扔了非val值，左边界才能往前走，同时，左边界往前走的步数，就是数组中非val值的个数
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            if(nums[left]==val){
                nums[left]=nums[right];
                right--;
            }else{
                left++;
            }
        }

        return left;
        
        
    }
    public static void main(String[] args){
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        int[] expectedNums = new int[0]; // 长度正确的预期答案。
        // 它以不等于 val 的值排序。

        int k = removeElement(nums, val); // 调用你的实现
        System.out.println("k="+k);
        assert k == expectedNums.length;
        sort(nums, 0, k); // 排序 nums 的前 k 个元素
        int actualLength = nums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
            System.out.println(nums[i]);
        }

    }
}
