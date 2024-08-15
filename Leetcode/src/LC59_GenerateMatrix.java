import java.util.Arrays;

public class LC59_GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int startx=0;
        int starty=0;
        int offset=1;
        int i,j;
        int nums[][]=new int[n][n];
        int count=0;
        int loop=1;//
        while(loop<=n/2){
            //一定记得用startx、starty、offset来定义i和j
            for(j = starty; j <n-offset; j++){
                count++;
                nums[startx][j]=count;
//                System.out.println(nums[startx][j]);
//                System.out.println("j:"+j);
//                System.out.println("n-offset:"+(n-offset));
            }
            for(i=startx;i<n-offset;i++){
                count++;
                nums[i][j]=count;
            }
            for(j=n-offset;j>starty;j--){
                count++;
                nums[i][j]=count;
            }
            for(i=n-offset;i>startx;i--){
                count++;
                nums[i][j]=count;
            }
            startx++;
            starty++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            count++;
            nums[startx][starty] = count;
        }
        return nums;
    }
    public static void main(String[] args){
        int n=3;
        int[][] result=generateMatrix(n);
        System.out.println(Arrays.deepToString(result));
    }
}
